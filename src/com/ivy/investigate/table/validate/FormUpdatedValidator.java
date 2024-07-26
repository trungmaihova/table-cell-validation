package com.ivy.investigate.table.validate;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("formUpdatedValidator")
public class FormUpdatedValidator implements Validator{

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String message = null;
		if(value == null || String.valueOf(value).isBlank()) {
			message = "Product code must not empty";
		} else if( String.valueOf(value).length() >= 9) {
			message = "Product code is less than 9 characters";
		}
		
		if(message != null) {		
			FacesMessage msg = new FacesMessage("Product code validation failed.", message);
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);	
		}		
	}
}