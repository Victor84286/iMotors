package br.edu.ibmec.cloudcomputing.imotors.errorHandler;

public class BusinessError {
    private String typeError = "BusinessException";
    private String message;

    public BusinessError(String typeError, String message) {
        super();
        this.typeError = typeError;
        this.message = message;
    }

    public String getTypeError() {
        return typeError;
    }

    public void setTypeError(String typeError) {
        this.typeError = typeError;
    }
}
