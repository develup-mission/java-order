package order.exception.message;

public enum ErrorMessage {

    ERROR_PREFIX("[ERROR]: ");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
