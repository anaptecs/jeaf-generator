package com.anaptecs.jeaf.fwk.generator.util.versioning;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.junit.jupiter.api.Test;

public class GeneratorVersionCheckTest {
  @Test
  void testVersionComparison( ) {
    assertTrue(isSupported("2.0.0", "2.0.0"));
    assertTrue(isSupported("2.0.1", "2.0.0"));
    assertTrue(isSupported("2.1.0", "2.0.5"));
    assertTrue(isSupported("10.0.0", "9.9.9"));
    assertTrue(isSupported("2.0.0-SNAPSHOT", "2.0.0"));
    assertTrue(isSupported("2.0.0", "2.0"));
    assertFalse(isSupported("1.32.4", "2.0.0"));
    assertFalse(isSupported("2.0.0", "2.0.1"));
    assertFalse(isSupported("1.9.0", "1.10.0"));
    assertFalse(isSupported("1.32.4-SNAPSHOT", "1.32.5"));

    // Check is skipped if a version is not known or invalid.
    assertTrue(isSupported("", "2.0.0"));
    assertTrue(isSupported(null, "2.0.0"));
    assertTrue(isSupported("1.0.0", null));
    assertTrue(isSupported("1.0.0", "next"));
  }

  @Test
  void testMinimumGeneratorVersionFromJMM( ) {
    assertEquals("2.0.0", GeneratorVersionCheck.getMinimumGeneratorVersion(createModel(true, " 2.0.0 ")));
    assertNull(GeneratorVersionCheck.getMinimumGeneratorVersion(createModel(true, "")));
    assertNull(GeneratorVersionCheck.getMinimumGeneratorVersion(createModel(true, null)));

    // JMM versions up to 2.13.0 do not define the attribute.
    assertNull(GeneratorVersionCheck.getMinimumGeneratorVersion(createModel(false, null)));

    // Model without JMM
    assertNull(GeneratorVersionCheck.getMinimumGeneratorVersion(UMLFactory.eINSTANCE.createModel()));
  }

  private static boolean isSupported( String pGeneratorVersion, String pMinimumVersion ) {
    return GeneratorVersionCheck.isSupported(pGeneratorVersion, pMinimumVersion);
  }

  /**
   * Creates a model that applies a minimal JMM profile with stereotype «ModelVersion» like the real JMM.
   */
  private static Model createModel( boolean pWithAttribute, String pMinimumGeneratorVersion ) {
    ResourceSet lResourceSet = createResourceSet();
    Model lMetamodel = (Model) lResourceSet.getResource(URI.createURI(UMLResource.UML_METAMODEL_URI), true)
        .getContents().get(0);
    org.eclipse.uml2.uml.Class lMetaclass = (org.eclipse.uml2.uml.Class) lMetamodel.getOwnedType("Class");
    Model lLibrary = (Model) lResourceSet
        .getResource(URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI), true).getContents().get(0);
    PrimitiveType lString = (PrimitiveType) lLibrary.getOwnedType("String");

    Profile lProfile = UMLFactory.eINSTANCE.createProfile();
    lProfile.setName("JMM");
    Resource lProfileResource = lResourceSet.createResource(URI.createURI("test:/JMM.profile.uml"));
    lProfileResource.getContents().add(lProfile);
    lProfile.createMetaclassReference(lMetaclass);
    Stereotype lModelVersion = lProfile.createOwnedStereotype("ModelVersion", false);
    lModelVersion.createExtension(lMetaclass, false);
    lModelVersion.createOwnedAttribute("versionName", lString);
    if (pWithAttribute) {
      lModelVersion.createOwnedAttribute("minimumGeneratorVersion", lString);
    }
    org.eclipse.uml2.uml.Class lVersion = lProfile.createOwnedClass("JMMVersion", false);
    lProfile.define();
    lProfile.applyProfile(lProfile);
    lVersion.applyStereotype(lModelVersion);
    lVersion.setValue(lModelVersion, "versionName", "JMM 9.9.9");
    if (pMinimumGeneratorVersion != null) {
      lVersion.setValue(lModelVersion, "minimumGeneratorVersion", pMinimumGeneratorVersion);
    }

    Model lModel = UMLFactory.eINSTANCE.createModel();
    lResourceSet.createResource(URI.createURI("test:/Model.uml")).getContents().add(lModel);
    lModel.applyProfile(lProfile);
    return lModel;
  }

  private static ResourceSet createResourceSet( ) {
    ResourceSet lResourceSet = new ResourceSetImpl();
    lResourceSet.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
    lResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
        UMLResource.Factory.INSTANCE);
    // Map UML2 path maps to the resources of the UML2 jar (standalone, outside of Eclipse)
    URL lMetamodel = UMLResource.class.getClassLoader().getResource("metamodels/UML.metamodel.uml");
    String lBase = lMetamodel.toString().substring(0, lMetamodel.toString().lastIndexOf("metamodels/"));
    lResourceSet.getURIConverter().getURIMap().put(URI.createURI(UMLResource.METAMODELS_PATHMAP),
        URI.createURI(lBase + "metamodels/"));
    lResourceSet.getURIConverter().getURIMap().put(URI.createURI(UMLResource.LIBRARIES_PATHMAP),
        URI.createURI(lBase + "libraries/"));
    lResourceSet.getURIConverter().getURIMap().put(URI.createURI(UMLResource.PROFILES_PATHMAP),
        URI.createURI(lBase + "profiles/"));
    return lResourceSet;
  }
}
