package com.anaptecs.jeaf.fwk.generator.util.versioning;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.info.VersionInfo;

/**
 * Checks if this version of JEAF Generator supports the JEAF Meta Model (JMM) of a UML model. Each JMM release defines
 * the minimum JEAF Generator version that supports it in attribute <code>minimumGeneratorVersion</code> of stereotype
 * «ModelVersion».
 */
public class GeneratorVersionCheck {
	static final String JMM_PROFILE = "JMM";

	static final String MODEL_VERSION = "ModelVersion";

	static final String MINIMUM_GENERATOR_VERSION = "minimumGeneratorVersion";

	/**
	 * Returns the minimum JEAF Generator version that is required by the JMM of the passed model or <code>null</code> if
	 * it is not defined. JMM versions up to 2.13.0 do not define the attribute.
	 */
	public static String getMinimumGeneratorVersion(Model pModel) {
		for (Profile lProfile : pModel.getAllAppliedProfiles()) {
			if (JMM_PROFILE.equals(lProfile.getName())) {
				for (Element lElement : lProfile.allOwnedElements()) {
					for (Stereotype lStereotype : lElement.getAppliedStereotypes()) {
						if (MODEL_VERSION.equals(lStereotype.getName())) {
							return getMinimumGeneratorVersion(lElement, lStereotype);
						}
					}
				}
			}
		}
		return null;
	}

	private static String getMinimumGeneratorVersion(Element pElement, Stereotype pModelVersion) {
		String lVersion = null;
		// Element.getValue(...) throws an exception for attributes that are not defined by the stereotype.
		if (pModelVersion.getAttribute(MINIMUM_GENERATOR_VERSION, null) != null) {
			Object lValue = pElement.getValue(pModelVersion, MINIMUM_GENERATOR_VERSION);
			if (lValue instanceof String && ((String) lValue).isBlank() == false) {
				lVersion = ((String) lValue).trim();
			}
		}
		return lVersion;
	}

	/**
	 * Returns the version of JEAF Generator or an empty string if it is unknown.
	 */
	public static String getGeneratorVersion() {
		VersionInfo lVersion = XFun.getVersionInfo();
		return lVersion.isUnknownVersion() ? "" : lVersion.getVersionString();
	}

	public static boolean isGeneratorVersionSupported(Model pModel) {
		return isSupported(getGeneratorVersion(), getMinimumGeneratorVersion(pModel));
	}

	/**
	 * Compares major, minor and bugfix level, so a snapshot counts as the version it leads to. If one of the versions is
	 * unknown or invalid, the check is skipped.
	 */
	static boolean isSupported(String pGeneratorVersion, String pMinimumVersion) {
		boolean lSupported = true;
		if (pGeneratorVersion != null && pGeneratorVersion.isBlank() == false && pMinimumVersion != null) {
			int[] lGenerator = parse(pGeneratorVersion);
			int[] lMinimum = parse(pMinimumVersion);
			if (lGenerator != null && lMinimum != null) {
				for (int i = 0; i < lGenerator.length; i++) {
					if (lGenerator[i] != lMinimum[i]) {
						lSupported = lGenerator[i] > lMinimum[i];
						break;
					}
				}
			}
		}
		return lSupported;
	}

	private static int[] parse(String pVersion) {
		String[] lParts = pVersion.trim().split("-", 2)[0].split("\\.");
		if (lParts.length < 2 || lParts.length > 3) {
			return null;
		}
		int[] lNumbers = new int[3];
		try {
			for (int i = 0; i < lParts.length; i++) {
				lNumbers[i] = Integer.parseInt(lParts[i]);
			}
		}
		catch (NumberFormatException e) {
			return null;
		}
		return lNumbers;
	}
}
