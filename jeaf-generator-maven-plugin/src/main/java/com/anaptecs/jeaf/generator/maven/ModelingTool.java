/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.generator.maven;

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
