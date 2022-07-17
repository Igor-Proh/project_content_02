package project_conten_02.prokhnov.exceptions;

public class ComponentNotFoundException extends RuntimeException {
    public ComponentNotFoundException() {
        super();
    }

    public ComponentNotFoundException(String message) {
        super(message);
    }

    public ComponentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
