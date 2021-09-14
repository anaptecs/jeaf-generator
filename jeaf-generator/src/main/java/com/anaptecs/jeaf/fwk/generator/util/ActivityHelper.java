package com.anaptecs.jeaf.fwk.generator.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;

public class ActivityHelper {

  public static List<Parameter> getInputParameters( Activity pActivity ) {
    EList<Parameter> lOwnedParameters = pActivity.getOwnedParameters();
    List<Parameter> lInputParameters = new ArrayList<Parameter>();
    for (Parameter lParameter : lOwnedParameters) {
      ParameterDirectionKind lDirection = lParameter.getDirection();
      if (lDirection == ParameterDirectionKind.IN_LITERAL || lDirection == ParameterDirectionKind.INOUT_LITERAL) {
        lInputParameters.add(lParameter);
      }
    }
    return lInputParameters;
  }

  public static Parameter getReturnParameter( Activity pActivity ) {
    EList<Parameter> lOwnedParameters = pActivity.getOwnedParameters();
    Parameter lReturnParameter = null;
    for (Parameter lParameter : lOwnedParameters) {
      if (lParameter.getDirection() == ParameterDirectionKind.RETURN_LITERAL) {
        lReturnParameter = lParameter;
        break;
      }
    }
    return lReturnParameter;
  }

  public static boolean hasReturnParameter( Activity pActivity ) {
    return ActivityHelper.getReturnParameter(pActivity) != null;
  }

  public static int getReturnParameterCount( Activity pActivity ) {
    EList<Parameter> lOwnedParameters = pActivity.getOwnedParameters();
    int lReturnParameterCount = 0;
    for (Parameter lParameter : lOwnedParameters) {
      if (lParameter.getDirection() == ParameterDirectionKind.RETURN_LITERAL) {
        lReturnParameterCount++;
      }
    }
    return lReturnParameterCount;
  }
}
