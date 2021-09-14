package com.anaptecs.jeaf.junit.impl.persistence;

import com.anaptecs.jeaf.junit.impl.domain.Mappings;
import com.anaptecs.jeaf.spi.persistence.annotations.PersistenceUnit;

/**
 * Persistence unit contains persistent classes of the following packages:
 * <ul>
 * <li>com.anaptecs.jeaf.junit.impl.domain</li>
 * </ul>
 */
@PersistenceUnit(
    name = "JUnitPersistenceUnit",
    mappingFilesDefinition = { Mappings.class },
    showSQL = "{jeaf.persistence.showSQL}",
    formatSQL = "{jeaf.persistence.formatSQL}")
public interface JUnitPersistenceUnit {
}