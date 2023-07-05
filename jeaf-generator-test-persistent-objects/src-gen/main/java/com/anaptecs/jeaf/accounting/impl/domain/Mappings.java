package com.anaptecs.jeaf.accounting.impl.domain;

import com.anaptecs.jeaf.spi.persistence.annotations.MappingFiles;

@MappingFiles(
    mappingFiles = { "com/anaptecs/jeaf/accounting/impl/domain/AccountBO.hbm.xml",
      "com/anaptecs/jeaf/accounting/impl/domain/BankBO.hbm.xml",
      "com/anaptecs/jeaf/accounting/impl/domain/BookingBO.hbm.xml",
      "com/anaptecs/jeaf/accounting/impl/domain/CustomerBO.hbm.xml",
      "com/anaptecs/jeaf/accounting/impl/domain/EmployeeBO.hbm.xml",
      "com/anaptecs/jeaf/accounting/impl/domain/MyAddressBO.hbm.xml",
      "com/anaptecs/jeaf/accounting/impl/domain/MyPersonBO.hbm.xml",
      "com/anaptecs/jeaf/accounting/impl/domain/ResponsibilityTypeBO.hbm.xml" })
public interface Mappings {
}