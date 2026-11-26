package com.anaptecs.jeaf.fwk.generator.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.eclipse.xpand2.Generator;
import org.eclipse.xpand2.output.FileHandle;
import org.eclipse.xpand2.output.FileHandleImpl;
import org.eclipse.xpand2.output.Outlet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.anaptecs.jeaf.fwk.generator.util.LineEnding;

public class LineEndingPostProcessorTest {
  @TempDir
  Path directory;

  @Test
  void testGeneratedFileGetsConfiguredLineEnding( ) throws Exception {
    Outlet lOutlet = new Outlet(directory.toString());
    lOutlet.setFileEncoding("UTF-8");
    lOutlet.addPostprocessor(new LineEndingPostProcessor(LineEnding.LF));
    File lFile = directory.resolve("Test.yaml").toFile();
    FileHandleImpl lHandle = new FileHandleImpl(lOutlet, lFile);
    lHandle.setBuffer(new StringBuilder("openapi: 3.0.3\r\ninfo:\n  description: |\r\n    Line 1\r    Line 2\n"));
    lHandle.writeAndClose();

    assertEquals("openapi: 3.0.3\ninfo:\n  description: |\n    Line 1\n    Line 2\n",
        Files.readString(lFile.toPath(), StandardCharsets.UTF_8));
  }

  @Test
  void testBufferWithoutChangesIsKept( ) {
    StringBuilder lBuffer = new StringBuilder("a\nb\n");
    FileHandle lHandle = new FileHandleImpl(new Outlet(directory.toString()), directory.resolve("A.java").toFile());
    lHandle.setBuffer(lBuffer);
    new LineEndingPostProcessor(LineEnding.LF).beforeWriteAndClose(lHandle);
    assertSame(lBuffer, lHandle.getBuffer());
  }

  @Test
  void testJEAFGeneratorAddsPostProcessorToAllOutlets( ) {
    Generator lGenerator = new JEAFGenerator();
    Outlet lFirst = new Outlet(directory.toString());
    Outlet lSecond = new Outlet(directory.resolve("gen").toString());
    lGenerator.addOutlet(lFirst);
    lGenerator.addOutlet(lSecond);
    assertTrue(lFirst.postprocessors.stream().anyMatch(p -> p instanceof LineEndingPostProcessor));
    assertTrue(lSecond.postprocessors.stream().anyMatch(p -> p instanceof LineEndingPostProcessor));
  }
}
