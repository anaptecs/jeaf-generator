package com.anaptecs.jeaf.fwk.generator.util;

import java.util.Arrays;

import com.vladsch.flexmark.ext.emoji.EmojiExtension;
import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughExtension;
import com.vladsch.flexmark.ext.gitlab.GitLabExtension;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;

public class JavadocHelper {
  private static final Parser markdownParser;

  private static final HtmlRenderer renderer;

  static {
    MutableDataSet lOptions = new MutableDataSet();
    // uncomment to set optional extensions
    lOptions.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create(), StrikethroughExtension.create(),
        EmojiExtension.create(), GitLabExtension.create()));

    // uncomment to convert soft-breaks to hard breaks
    lOptions.set(HtmlRenderer.SOFT_BREAK, "<br/>");
    lOptions.set(HtmlRenderer.SUPPRESS_HTML_BLOCKS, true);
    lOptions.set(EmojiExtension.USE_UNICODE_FILE_NAMES, true);
    lOptions
        .set(EmojiExtension.ROOT_IMAGE_PATH, "https://raw.githubusercontent.com/anaptecs/emoji-images/master/imgs/");

    markdownParser = Parser.builder(lOptions).build();
    renderer = HtmlRenderer.builder(lOptions).build();
  }

  public static String convertCommentForJavadoc( String pComment ) {
    String lJavadoc;
    if (pComment != null) {
      Node lDocument = markdownParser.parse(pComment.trim());
      lJavadoc = renderer.render(lDocument).trim();
      if (lJavadoc.startsWith("<p>")) {
        lJavadoc = lJavadoc.substring(3);
      }
      if (lJavadoc.endsWith("</p>")) {
        lJavadoc = lJavadoc.substring(0, lJavadoc.length() - 4);
      }
      lJavadoc = lJavadoc.replaceAll("</p>\n<p>", "<br/><br/>");
    }
    else {
      lJavadoc = "";
    }
    return lJavadoc;
  }
}
