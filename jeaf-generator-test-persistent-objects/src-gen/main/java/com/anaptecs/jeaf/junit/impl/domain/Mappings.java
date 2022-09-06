package com.anaptecs.jeaf.junit.impl.domain;

import com.anaptecs.jeaf.spi.persistence.annotations.MappingFiles;

@MappingFiles(
    mappingFiles = { "com/anaptecs/jeaf/junit/impl/domain/AOneBO.hbm.xml",
      "com/anaptecs/jeaf/junit/impl/domain/BOneBO.hbm.xml", "com/anaptecs/jeaf/junit/impl/domain/BaseClassBO.hbm.xml",
      "com/anaptecs/jeaf/junit/impl/domain/CManyBO.hbm.xml", "com/anaptecs/jeaf/junit/impl/domain/ClassA_BO.hbm.xml",
      "com/anaptecs/jeaf/junit/impl/domain/ClassB_BO.hbm.xml",
      "com/anaptecs/jeaf/junit/impl/domain/DeprecatedPO.hbm.xml",
      "com/anaptecs/jeaf/junit/impl/domain/FlushTestMasterBO.hbm.xml",
      "com/anaptecs/jeaf/junit/impl/domain/FlushTestSlaveBO.hbm.xml",
      "com/anaptecs/jeaf/junit/impl/domain/MReleationBO.hbm.xml",
      "com/anaptecs/jeaf/junit/impl/domain/NReleationBO.hbm.xml",
      "com/anaptecs/jeaf/junit/impl/domain/OrderingA.hbm.xml", "com/anaptecs/jeaf/junit/impl/domain/OrderingB.hbm.xml",
      "com/anaptecs/jeaf/junit/impl/domain/PublicClassBO.hbm.xml" })
public interface Mappings {
}