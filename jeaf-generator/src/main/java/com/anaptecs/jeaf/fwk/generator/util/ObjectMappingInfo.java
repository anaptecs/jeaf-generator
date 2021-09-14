package com.anaptecs.jeaf.fwk.generator.util;

import com.anaptecs.jeaf.xfun.api.checks.Assert;

public class ObjectMappingInfo {
  private final boolean onCreate;

  private final boolean onUpdate;

  private final boolean onRead;

  public ObjectMappingInfo( boolean pOnCreate, boolean pOnUpdate, boolean pOnRead ) {
    onCreate = pOnCreate;
    onUpdate = pOnUpdate;
    onRead = pOnRead;
  }

  public boolean onCreate( ) {
    return onCreate;
  }

  public boolean onUpdate( ) {
    return onUpdate;
  }

  public boolean onRead( ) {
    return onRead;
  }

  public boolean isMappingTypeEnabled( MappingType pMappingType ) {
    boolean lIsMappingTypeEnabled;
    switch (pMappingType) {
      case ON_CREATE:
        lIsMappingTypeEnabled = onCreate;
        break;

      case ON_UPDATE:
        lIsMappingTypeEnabled = onUpdate;
        break;

      case ON_READ:
        lIsMappingTypeEnabled = onRead;
        break;

      default:
        Assert.internalError("Unexpected enumeration literal " + pMappingType.name());
        lIsMappingTypeEnabled = false;
    }
    return lIsMappingTypeEnabled;
  }

  @Override
  public String toString( ) {
    return "Object-Mapping (onCreate: " + onCreate + " onUpdate: " + onUpdate + " onRead: " + onRead + ")";
  }
}
