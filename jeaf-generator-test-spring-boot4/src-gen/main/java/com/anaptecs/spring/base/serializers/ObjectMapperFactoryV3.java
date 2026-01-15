/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.serializers;

import com.anaptecs.jeaf.rest.composite.api.CompositeTypeConverter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.MapperFeature;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.json.JsonMapper.Builder;

/**
 * Object Mapper Factory can be used to create a Jackson {@link ObjectMapper} that can be used to serialize and
 * deserialize objects to / from JSON using Jackson.
 */
public class ObjectMapperFactoryV3 {
  /**
   * Method creates a ready-to-use Jackson Object Mapper. The created object will be configured so that it matches best
   * to the generated classes. It will also use the serializer modules as it was defined in the UML model.
   *
   * @param pCompositeTypeConverter {@link CompositeTypeConverter} implementation that should be used to serialize /
   * deserialize composite data types.
   * @return {@link ObjectMapper} Created object mapper. The method never returns null.
   */
  public static ObjectMapper createObjectMapper( CompositeTypeConverter pCompositeTypeConverter ) {
    // Create builder for object mapper.
    Builder lBuilder = JsonMapper.builder();
    // Set default visibilities so that they match to the generated classes that are intended to be serialized using
    // Jackson
    lBuilder.changeDefaultVisibility(v -> v.withFieldVisibility(JsonAutoDetect.Visibility.ANY));
    lBuilder.changeDefaultVisibility(v -> v.withGetterVisibility(JsonAutoDetect.Visibility.NONE));
    lBuilder.changeDefaultVisibility(v -> v.withIsGetterVisibility(JsonAutoDetect.Visibility.NONE));
    lBuilder.changeDefaultVisibility(v -> v.withSetterVisibility(JsonAutoDetect.Visibility.NONE));
    lBuilder.changeDefaultVisibility(v -> v.withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
    // Configure which properties should be included by default.
    lBuilder.changeDefaultPropertyInclusion(i -> i.withValueInclusion(Include.NON_EMPTY));
    lBuilder.changeDefaultPropertyInclusion(i -> i.withContentInclusion(Include.NON_EMPTY));
    // For better backward compatibility with Jackson 2 we preserve the following settings as there were in Jackson 2
    //
    // For further details please have a look here:
    // https://github.com/FasterXML/jackson/blob/main/jackson3/MIGRATING_TO_JACKSON_3.md
    lBuilder.disable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
    lBuilder.enable(MapperFeature.ALLOW_FINAL_FIELDS_AS_MUTATORS);
    // Configure mapper features
    lBuilder.enable(MapperFeature.PROPAGATE_TRANSIENT_MARKER);
    lBuilder.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
    // Create configured modules and add them as well.
    lBuilder.addModule(BaseModuleFactoryV3.createDataTypeSerializerModule());
    lBuilder.addModule(BaseModuleFactoryV3.createCompositeDataTypeSerializerModule(pCompositeTypeConverter));
    lBuilder.addModule(BaseModuleFactoryV3.createEnumSerializerModule());
    lBuilder.addModule(CompositeModuleFactoryV3.createDataTypeSerializerModule());
    lBuilder.addModule(CompositeModuleFactoryV3.createCompositeDataTypeSerializerModule(pCompositeTypeConverter));
    lBuilder.addModule(CompositeModuleFactoryV3.createEnumSerializerModule());
    lBuilder.addModule(TechBaseModuleFactoryV3.createDataTypeSerializerModule());
    lBuilder.addModule(TechBaseModuleFactoryV3.createEnumSerializerModule());
    // Create object mapper and return it
    return lBuilder.build();
  }
}