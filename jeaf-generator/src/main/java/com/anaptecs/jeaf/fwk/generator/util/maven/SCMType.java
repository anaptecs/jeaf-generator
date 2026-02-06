package com.anaptecs.jeaf.fwk.generator.util.maven;

public enum SCMType {
	GIT("scm:git:", ".git"), SVN("scm:svn:", "");

	private final String mavenSCMPrefix;
	private final String mavenSCMExtension;

	private SCMType(String mavenSCMPrefix, String mavenSCMExtension) {
		this.mavenSCMPrefix = mavenSCMPrefix;
		this.mavenSCMExtension = mavenSCMExtension;
	}

	public String getMavenSCMPrefix() {
		return mavenSCMPrefix;
	}

	public String getMavenSCMExtension() {
		return mavenSCMExtension;
	}

	public static String getMavenConnection(String pLiteralName, String pURL) {
		SCMType lSCMType = SCMType.valueOf(pLiteralName);
		return lSCMType.mavenSCMPrefix + pURL + lSCMType.mavenSCMExtension;
	}
}
