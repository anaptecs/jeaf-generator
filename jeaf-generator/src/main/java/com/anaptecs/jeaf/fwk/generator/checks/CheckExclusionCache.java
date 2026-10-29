package com.anaptecs.jeaf.fwk.generator.checks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckExclusionCache {
	private static Map<String, CheckExclusion> cache = new HashMap<String, CheckExclusion>();

	public static void setExclusions(List<CheckExclusion> pCheckExclusions) {
		clearCache();
		for (int i = 0; i < pCheckExclusions.size(); i++) {
			CheckExclusion lCheckExclusion = pCheckExclusions.get(i);
			cache.put(lCheckExclusion.getModelElementName(), lCheckExclusion);
		}
	}

	public static boolean isExcluded(String pModelElementName, String pCheckCode) {
		CheckExclusion lCheckExclusion = cache.get(pModelElementName);
		boolean lExcluded;
		if (lCheckExclusion != null) {
			lExcluded = lCheckExclusion.isExcludedFromCheck(pCheckCode);
		} else {
			lExcluded = false;
		}
		return lExcluded;
	}

	public static void clearCache() {
		cache.clear();
	}
}
