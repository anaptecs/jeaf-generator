package com.anaptecs.jeaf.fwk.generator.util;

public enum ModelingTool {
  MAGIC_DRAW("MagicDraw UML"), ECLIPSE_PAPYRUS("Eclipse Papyrus"), OTHER("Unknown Modeling Tool");

  private final String displayName;

  private ModelingTool( String pDisplayName ) {
    displayName = pDisplayName;
  }

  public String getDisplayName( ) {
    return displayName;
  }
}