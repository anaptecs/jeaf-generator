package com.anaptecs.jeaf.fwk.generator.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.anaptecs.jeaf.fwk.generator.util.JavadocHelper;

public class MarkdownConverterTest {
  @Test
  void testMarkdownConversion( ) {
    assertEquals("Hello World!", JavadocHelper.convertCommentForJavadoc("Hello World!"));
    assertEquals("Hello <strong>World</strong>!", JavadocHelper.convertCommentForJavadoc("Hello **World**!"));

    // You can re-use parser and renderer instances
    String lComment = "Hello World!:koala:<br>\n\n| Syntax      | Description |\n" + "| ----------- | ----------- |\n"
        + "| Header      | Title       |\n"
        + "| Paragraph   | Text        |\nLet's have an additional discussion about how much sense it makes to add :koala: to your documentation.\n"
        + "\nSo far I think it is at least funny.";

    String lResult = JavadocHelper.convertCommentForJavadoc(lComment);
    String lExpected =
        "Hello World!<img src=\"https://raw.githubusercontent.com/anaptecs/emoji-images/master/imgs/1f428.png\" alt=\"emoji github:koala\" height=\"20\" width=\"20\" align=\"absmiddle\" /><br></p>\n"
            + "<table>\n" + "<thead>\n" + "<tr><th>Syntax</th><th>Description</th></tr>\n" + "</thead>\n" + "<tbody>\n"
            + "<tr><td>Header</td><td>Title</td></tr>\n" + "<tr><td>Paragraph</td><td>Text</td></tr>\n" + "</tbody>\n"
            + "</table>\n"
            + "<p>Let's have an additional discussion about how much sense it makes to add <img src=\"https://raw.githubusercontent.com/anaptecs/emoji-images/master/imgs/1f428.png\" alt=\"emoji github:koala\" height=\"20\" width=\"20\" align=\"absmiddle\" /> to your documentation.<br/><br/>So far I think it is at least funny.";
    assertEquals(lExpected, lResult);
  }
}
