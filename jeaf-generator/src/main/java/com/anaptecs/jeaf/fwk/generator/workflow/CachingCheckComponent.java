package com.anaptecs.jeaf.fwk.generator.workflow;

import org.eclipse.xtend.check.CheckComponent;

/**
 * Check component used by the JEAF Generator workflows.
 * <p>
 * Xpand 2.2 caches the resolution of extensions itself, so the standard execution context is used (PoC of the
 * migration from oAW 4.3.1 to Xpand 2.2).
 */
public class CachingCheckComponent extends CheckComponent {
}
