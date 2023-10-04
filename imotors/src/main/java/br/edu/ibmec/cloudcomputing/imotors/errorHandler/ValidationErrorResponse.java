package br.edu.ibmec.cloudcomputing.imotors.errorHandler;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorResponse {
    private String errorMessage = "Aconteceu um problema com suasolicitacao";
    private List<Validation> errors = new ArrayList<Validation>();

    public List<Validation> getErrors() {
        return errors;
    }

    public void setErrors(List<Validation> errors) {
        this.errors = errors;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void addErrorValidation(String field, String message){
        this.errors.add(new Validation(field, message));
    }
}
