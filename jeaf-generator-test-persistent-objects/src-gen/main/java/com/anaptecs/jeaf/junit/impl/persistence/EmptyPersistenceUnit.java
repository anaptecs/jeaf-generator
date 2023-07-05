package com.anaptecs.jeaf.junit.impl.persistence;

import com.anaptecs.jeaf.spi.persistence.annotations.PersistenceUnit;

/**
 * Persistence unit contains persistent classes of the following packages:
 * <ul>
 * </ul>
 */
@PersistenceUnit(
    name = "EmptyPersistenceUnit",
    mappingFilesDefinition = {},
    showSQL = "{jeaf.persistence.EmptyPersistenceUnit.showSQL}",
    formatSQL = "{jeaf.persistence.EmptyPersistenceUnit.formatSQL}")
public interface EmptyPersistenceUnit {
}