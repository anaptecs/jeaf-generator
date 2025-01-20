package com.anaptecs.jeaf.fwk.generator.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateParameterSubstitution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TemplateParameterHelper {

	public static List<String> getTypeParameterNames(Class pClass) {
		try {
			TemplateBinding lTemplateBinding = (TemplateBinding) pClass.getTemplateBindings().get(0);
			TemplateSignature lTemplateSignature = lTemplateBinding.getSignature();
			EList<TemplateParameter> lOwnedParameters = lTemplateSignature.getOwnedParameters();
			List<String> lTemplateParamNames = new java.util.ArrayList<String>();
			for (TemplateParameter lNext : lOwnedParameters) {
				NamedElement lNamedElement = (NamedElement) lNext.getOwnedParameteredElement();
				lTemplateParamNames.add(lNamedElement.getName());
			}

			Map<String, String> lMapping = getActualTemplateParameterTypes(lTemplateBinding);

			List<String> lTypeParamNames = new ArrayList<String>();
			for (String lNext : lTemplateParamNames) {
				lTypeParamNames.add(lMapping.get(lNext));
			}
			return lTypeParamNames;

		} catch (RuntimeException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	private static Map<String, String> getActualTemplateParameterTypes(TemplateBinding pTemplateBinding) {
		EList<TemplateParameterSubstitution> lParameterSubstitutions = pTemplateBinding.getParameterSubstitutions();
		Map<String, String> lMapping = new HashMap<String, String>();
		for (TemplateParameterSubstitution lNext : lParameterSubstitutions) {
			EList<ParameterableElement> lActuals = lNext.getActuals();
			ParameterableElement lParameterableElement = lActuals.get(0);
			NamedElement lTemplateParamName = (NamedElement) lNext.getFormal().getParameteredElement();
			NamedElement lActual = (NamedElement) lParameterableElement;
			String lFullyQualifiedName = Naming.getFullyQualifiedName(lActual);
			lMapping.put(lTemplateParamName.getName(), lFullyQualifiedName);
		}
		return lMapping;
	}
}
