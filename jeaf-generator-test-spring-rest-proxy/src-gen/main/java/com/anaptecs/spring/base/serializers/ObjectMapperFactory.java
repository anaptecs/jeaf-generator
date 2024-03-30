/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;

/**
 * Object Mapper Factory can be used to create a Jackson {@link ObjectMapper} that can be used to serialize and
 * deserialize objects to / from JSON using Jackson.
 */
public class ObjectMapperFactory {
  /**
   * Method creates a ready-to-use Jackson Object Mapper. The created object will be configured so that it matches best
   * to the generated classes. It will also use the serializer modules as it was defined in the UML model.
   *
   * @return {@link ObjectMapper} Created object mapper. The method never returns null.
   */
  public static ObjectMapper createObjectMapper( ) {
    // Create builder for object mapper.
    Builder lBuilder = JsonMapper.builder();
    // Set default visibilities so that they match to the generated classes that are intended to be serialized using
    // Jackson
    VisibilityChecker<?> lVisibilityChecker = VisibilityChecker.Std.defaultInstance();
    lVisibilityChecker = lVisibilityChecker.withFieldVisibility(JsonAutoDetect.Visibility.ANY);
    lVisibilityChecker = lVisibilityChecker.withGetterVisibility(JsonAutoDetect.Visibility.NONE);
    lVisibilityChecker = lVisibilityChecker.withIsGetterVisibility(JsonAutoDetect.Visibility.NONE);
    lVisibilityChecker = lVisibilityChecker.withSetterVisibility(JsonAutoDetect.Visibility.NONE);
    lVisibilityChecker = lVisibilityChecker.withCreatorVisibility(JsonAutoDetect.Visibility.ANY);
    lBuilder.visibility(lVisibilityChecker);
    // Configure mapper features
    lBuilder.enable(MapperFeature.PROPAGATE_TRANSIENT_MARKER);
    lBuilder.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
    // Create configured modules and add them as well.
    lBuilder.addModule(BaseModuleFactory.createDataTypeSerializerModule());
    lBuilder.addModule(BaseModuleFactory.createEnumSerializerModule());
    lBuilder.addModule(TechBaseModuleFactory.createDataTypeSerializerModule());
    lBuilder.addModule(TechBaseModuleFactory.createEnumSerializerModule());
    lBuilder.addModule(CompositeModuleFactory.createDataTypeSerializerModule());
    lBuilder.addModule(CompositeModuleFactory.createEnumSerializerModule());
    // Create object mapper and return it
    JsonMapper lObjectMapper = lBuilder.build();
    lObjectMapper.setDefaultPropertyInclusion(Include.NON_EMPTY);
    return lObjectMapper;
  }
}