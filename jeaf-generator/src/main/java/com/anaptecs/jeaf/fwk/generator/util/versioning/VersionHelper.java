package com.anaptecs.jeaf.fwk.generator.util.versioning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.anaptecs.jeaf.xfun.api.info.VersionInfo;

public class VersionHelper {
	public static Date TODAY = new Date();

	public static String getLatestMatchingVersion(String pMyVersion, List<String> pOtherVersions) {
		VersionInfo lMyVersion = new VersionInfo(pMyVersion, TODAY);

		List<VersionInfo> lVersions = new ArrayList<VersionInfo>();
		for (String lNext : pOtherVersions) {
			VersionInfo lNewVersion = new VersionInfo(lNext, TODAY);
			if (lMyVersion.getMajorVersion() == lNewVersion.getMajorVersion()) {
				lVersions.add(lNewVersion);
			}
		}
		if (lVersions.size() > 0) {
			Collections.sort(lVersions, new LatestVersionComparator());
			VersionInfo lMatchingVersion = lVersions.get(0);
			return lMatchingVersion.getMajorVersion() + "." + lMatchingVersion.getMinorVersion() + "."
					+ lMatchingVersion.getBugfixLevel();
		} else {
			return "";
		}
	}

	public static String getLatestVersion(List<String> pVersionStrings) {
		if (pVersionStrings.size() > 0) {
			List<VersionInfo> lVersions = new ArrayList<VersionInfo>();
			for (String lNext : pVersionStrings) {
				lVersions.add(new VersionInfo(lNext, TODAY));
			}
			Collections.sort(lVersions, new LatestVersionComparator());
			VersionInfo lLatestVersion = lVersions.get(0);
			return lLatestVersion.getMajorVersion() + "." + lLatestVersion.getMinorVersion() + "."
					+ lLatestVersion.getBugfixLevel();
		} else {
			return "";
		}
	}
}

class LatestVersionComparator implements Comparator<VersionInfo> {
	public int compare(VersionInfo pMyVersion, VersionInfo pOtherVersion) {
		int lResult;
		// Same major versions
		if (pMyVersion.getMajorVersion() == pOtherVersion.getMajorVersion()) {
			// Same minor versions
			if (pMyVersion.getMinorVersion() == pOtherVersion.getMinorVersion()) {
				lResult = Integer.valueOf(pMyVersion.getBugfixLevel()).compareTo(pOtherVersion.getBugfixLevel());
			}
			// Different minor versions
			else {
				lResult = Integer.valueOf(pMyVersion.getMinorVersion()).compareTo(pOtherVersion.getMinorVersion());
			}
		}
		// Different major versions
		else {
			lResult = Integer.valueOf(pMyVersion.getMajorVersion()).compareTo(pOtherVersion.getMajorVersion());
		}
		return -1 * lResult;
	}
}
