package com.anaptecs.jeaf.fwk.generator.workflow;

import org.eclipse.xpand2.output.FileHandle;
import org.eclipse.xpand2.output.PostProcessor;

import com.anaptecs.jeaf.fwk.generator.util.LineEnding;

/**
 * Converts the line breaks of every generated file to the configured line ending before it is written. Line breaks
 * come from templates, extensions and comments of the UML model, which may all use different ones.
 */
public class LineEndingPostProcessor implements PostProcessor {
  private final LineEnding lineEnding;

  public LineEndingPostProcessor( LineEnding pLineEnding ) {
    lineEnding = pLineEnding;
  }

  @Override
  public void beforeWriteAndClose( FileHandle pFile ) {
    CharSequence lBuffer = pFile.getBuffer();
    CharSequence lNormalized = lineEnding.normalize(lBuffer);
    if (lNormalized != lBuffer) {
      pFile.setBuffer(lNormalized);
    }
  }

  @Override
  public void afterClose( FileHandle pFile ) {
    // Nothing to do after the file was written.
  }
}
