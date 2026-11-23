/**
 * Copyright 2004 - 2026 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.generator.maven;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.DefaultArtifact;
import org.apache.maven.artifact.handler.DefaultArtifactHandler;
import org.apache.maven.plugin.MojoFailureException;
import org.junit.jupiter.api.Test;

public class PluginDependencyCheckTest {
  private static Artifact artifact( String pGroupId, String pArtifactId, String pVersion ) {
    return new DefaultArtifact(pGroupId, pArtifactId, pVersion, "compile", "jar", null,
        new DefaultArtifactHandler("jar"));
  }

  @Test
  void testNoOAWArtifacts( ) {
    List<Artifact> lArtifacts = List.of(artifact("com.anaptecs.jeaf.xpand", "xpand", "3.0.0"),
        artifact("com.anaptecs.jeaf.uml2libs", "uml2-uml", "5.6.1"));
    assertTrue(GeneratorMojo.findOAWArtifacts(lArtifacts).isEmpty());
    assertTrue(GeneratorMojo.findOAWArtifacts(null).isEmpty());
    assertDoesNotThrow(( ) -> new GeneratorMojo().checkPluginDependencies(lArtifacts));
  }

  @Test
  void testOAWArtifactsAreReported( ) {
    Artifact lUML2 = artifact(GeneratorMojo.OAW_GROUP_ID, "org.eclipse.uml2.uml", "4.3.1");
    lUML2.setDependencyTrail(List.of("com.anaptecs.jeaf.generator:jeaf-generator-maven-plugin:maven-plugin:2.0.0",
        "com.example:my-templates:jar:1.0.0", lUML2.getId()));
    List<Artifact> lArtifacts = List.of(artifact("com.anaptecs.jeaf.xpand", "xpand", "3.0.0"),
        artifact(GeneratorMojo.OAW_GROUP_ID, "antlr-runtime", "4.3.1"), lUML2);

    assertEquals(List.of("com.anaptecs.jeaf.owalibs:antlr-runtime:jar:4.3.1",
        "com.anaptecs.jeaf.owalibs:org.eclipse.uml2.uml:jar:4.3.1 (via com.example:my-templates:jar:1.0.0)"),
        GeneratorMojo.findOAWArtifacts(lArtifacts));
    assertThrows(MojoFailureException.class, ( ) -> new GeneratorMojo().checkPluginDependencies(lArtifacts));
  }
}
