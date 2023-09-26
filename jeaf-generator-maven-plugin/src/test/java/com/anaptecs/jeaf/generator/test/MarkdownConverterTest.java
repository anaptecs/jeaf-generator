package com.anaptecs.jeaf.generator.test;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.vladsch.flexmark.ext.emoji.EmojiExtension;
import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughExtension;
import com.vladsch.flexmark.ext.gitlab.GitLabExtension;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;

public class MarkdownConverterTest {
  /**
   * <p>
   * Hello World!<img src="https://raw.githubusercontent.com/anaptecs/emoji-images/master/imgs/1f428.png" alt="emoji
   * github:koala" height="20" width="20" align="absmiddle" /><br>
   * </p>
   * <table>
   * <thead>
   * <tr>
   * <th>Syntax</th>
   * <th>Description</th>
   * </tr>
   * </thead> <tbody>
   * <tr>
   * <td>Header</td>
   * <td>Title</td>
   * </tr>
   * <tr>
   * <td>Paragraph</td>
   * <td>Text</td>
   * </tr>
   * </tbody>
   * </table>
   * 
   */
  @Test
  void testMarkdownConversion( ) {
    MutableDataSet options = new MutableDataSet();

    // uncomment to set optional extensions
    options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create(), StrikethroughExtension.create(),
        EmojiExtension.create(), GitLabExtension.create()));

    // uncomment to convert soft-breaks to hard breaks
    // options.set(HtmlRenderer.SOFT_BREAK, "<br />\n");
    options.set(EmojiExtension.USE_UNICODE_FILE_NAMES, true);
    options.set(EmojiExtension.ROOT_IMAGE_PATH, "https://raw.githubusercontent.com/anaptecs/emoji-images/master/imgs/");

    Parser parser = Parser.builder(options).build();
    HtmlRenderer renderer = HtmlRenderer.builder(options).build();

    // You can re-use parser and renderer instances
    Node document = parser.parse("Hello World!:koala:<br>\n\n| Syntax      | Description |\n"
        + "| ----------- | ----------- |\n" + "| Header      | Title       |\n" + "| Paragraph   | Text        |");
    String html = renderer.render(document); // "<p>This is <em>Sparta</em></p>\n"
    System.out.println(html);
  }
}
