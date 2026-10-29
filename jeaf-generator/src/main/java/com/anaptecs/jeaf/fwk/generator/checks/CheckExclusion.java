package com.anaptecs.jeaf.fwk.generator.checks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckExclusion {

	private String modelElementName;

	private List<String> excludedChecks = new ArrayList<String>();

	public CheckExclusion() {
	}

	public String getModelElementName() {
		return modelElementName;
	}

	public void setModelElementName(String pMmodelElementName) {
		this.modelElementName = pMmodelElementName;
	}

	public void setExcludedChecks(String pExcludedChecks) {
		excludedChecks.addAll(Arrays.asList(pExcludedChecks.split(";")));
	}

	public boolean isExcludedFromCheck(String pCheckCode) {
		boolean lExcluded;
		if (excludedChecks.size() > 0) {
			if (pCheckCode != null && pCheckCode.trim().length() > 0) {
				lExcluded = excludedChecks.contains(pCheckCode);
			} else {
				lExcluded = false;
			}
		} else {
			lExcluded = true;
		}
		return lExcluded;
	}
}
