package com.anaptecs.jeaf.accounting.impl;

import com.anaptecs.jeaf.accounting.impl.domain.Mappings;
import com.anaptecs.jeaf.spi.persistence.annotations.PersistenceUnit;

/**
 * Persistence unit contains persistent classes of the following packages:
 * <ul>
 * <li>com.anaptecs.jeaf.accounting.impl.domain</li>
 * <li>com.anaptecs.jeaf.accounting.impl.swift.impl.domain</li>
 * </ul>
 */
@PersistenceUnit(
    name = "AccountingPersistenceUnit",
    mappingFilesDefinition = { Mappings.class, com.anaptecs.jeaf.accounting.impl.swift.impl.domain.Mappings.class },
    showSQL = "true",
    formatSQL = "true")
public interface AccountingPersistenceUnit {
}