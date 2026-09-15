package com.anaptecs.jeaf.fwk.generator.util.umldiagram;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.vladsch.flexmark.html2md.converter.FlexmarkHtmlConverter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class UMLDiagramHelper {
    private static List<UMLDiagram> umlDiagrams = new ArrayList<UMLDiagram>();

    public static void loadUMLDiagrams(String pFilePath)
            throws IOException, ParserConfigurationException, SAXException {
        File lFile = new File(pFilePath);
        if (lFile.exists()) {
            DocumentBuilder lDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document lXML = lDocumentBuilder.parse(lFile);
            lXML.getDocumentElement().normalize();
            NodeList lDiagramElements = lXML.getElementsByTagName("diagram");

            String lIDPrefix = "./images/EPID__PROJECT-";
            for (int i = 0; i < lDiagramElements.getLength(); i++) {
                Element lNextDiagram = (Element) lDiagramElements.item(i);

                String lRawImagePath = lNextDiagram.getElementsByTagName("imagePath").item(0).getTextContent()
                        .replace("\\", "/");
                int lLastIndex = lRawImagePath.lastIndexOf("/");
                String lImagePath = "./images" + lRawImagePath.substring(lLastIndex).trim();
                String lDiagramID = lImagePath.replace(lIDPrefix, "").replace(".png", "");
                String lOwner = lNextDiagram.getElementsByTagName("owner").item(0).getTextContent().trim();
                String lName = lNextDiagram.getElementsByTagName("name").item(0).getTextContent().trim();
                String lDiagramType = lNextDiagram.getElementsByTagName("diagramType").item(0).getTextContent().trim();
                String lComment = lNextDiagram.getElementsByTagName("comment").item(0).getTextContent().trim();
                String lOrderAsString = lNextDiagram.getElementsByTagName("order").item(0).getTextContent().trim();
                if (lOrderAsString.length() == 0) {
                    lOrderAsString = "9999";
                }
                umlDiagrams
                        .add(new UMLDiagram(lDiagramID, lOwner, lName, lDiagramType, lImagePath, lComment,
                                Integer.valueOf(lOrderAsString)));
            }
        } else {
            System.err.println(
                    "Unable to read diagram info from file " + pFilePath + "(full path: " + lFile.getCanonicalPath()
                            + ").");
        }
    }

    public static List<UMLDiagram> getDiagramsForPackage(String pPackageName) {
        return umlDiagrams.stream().filter(d -> d.owner().startsWith(pPackageName))
                .sorted(Comparator.comparing(UMLDiagram::name)).toList();
    }

    public static List<String> getDiagramIDsForPackage(String pPackageName) {
        return getDiagramsForPackage(pPackageName).stream().map(UMLDiagram::id).toList();
    }

    public static List<String> getDiagramNamesForPackage(String pPackageName) {
        return getDiagramsForPackage(pPackageName).stream().map(UMLDiagram::name).toList();
    }

    public static List<String> getDiagramDiagramTypesForPackage(String pPackageName) {
        return getDiagramsForPackage(pPackageName).stream().map(UMLDiagram::diagramType).toList();
    }

    public static List<String> getDiagramImagePathsForPackage(String pPackageName) {
        return getDiagramsForPackage(pPackageName).stream().map(UMLDiagram::imagePath).toList();
    }

    public static List<String> getDiagramCommentsForPackage(String pPackageName) {
        return getDiagramsForPackage(pPackageName).stream().map(UMLDiagram::comment).toList();
    }

    public static String getModelVersion(String pModelVersionFile) {
        File lFile = new File(pModelVersionFile);
        try {
            return Files.readString(lFile.toPath()).trim();
        } catch (IOException e) {
            return "unknown";
        }
    }

    public static String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm::ss"));
    }

    public static String convertHTML2Markdown(String html) {
        return FlexmarkHtmlConverter.builder().build().convert(html);
    }
}
