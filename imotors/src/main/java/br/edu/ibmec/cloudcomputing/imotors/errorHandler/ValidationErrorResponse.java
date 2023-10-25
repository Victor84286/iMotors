package br.edu.ibmec.cloudcomputing.imotors.errorHandler;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorResponse {
    private String errorMessage = "Aconteceu um problema com suasolicitacao";
    private List<Validation> validationErrors = new ArrayList<Validation>();
    private List<BusinessError> businessErrors = new ArrayList<BusinessError>();

    public List<BusinessError> getBusinessErrors() {
        return businessErrors;
    }

    public void setBusinessErrors(List<BusinessError> businessErrors) {
        this.businessErrors = businessErrors;
    }

    public List<Validation> getErrors() {
        return validationErrors;
    }

    public void setErrors(List<Validation> errors) {
        this.validationErrors = errors;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void addErrorValidation(String field, String message){
        this.validationErrors.add(new Validation(field, message));
    }
}
