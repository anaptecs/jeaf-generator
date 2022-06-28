/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.test;

import com.anaptecs.jeaf.core.servicechannel.jaas.UserPrincipalBasedLocaleProviderFactoryImpl;
import com.anaptecs.jeaf.workload.annotations.PipelineConfig;
import com.anaptecs.jeaf.xfun.annotations.AppInfo;
import com.anaptecs.jeaf.xfun.annotations.RuntimeInfo;
import com.anaptecs.jeaf.xfun.annotations.XFunConfig;
import com.anaptecs.jeaf.xfun.api.info.RuntimeEnvironment;

@AppInfo(applicationID = "JEAFRestProxyTest", applicationName = "JEAF REST Proxy Test")

@RuntimeInfo(runtimeEnvironment = RuntimeEnvironment.WEB_CONTAINER)

@XFunConfig(localeProviderFactory = UserPrincipalBasedLocaleProviderFactoryImpl.class)

@PipelineConfig(coreThreads = 5, defaultPipeline = true)
public interface WebAppConfiguration {
}
