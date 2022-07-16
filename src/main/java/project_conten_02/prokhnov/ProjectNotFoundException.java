package project_conten_02.prokhnov;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException() {
        super();
    }

    public ProjectNotFoundException(String message) {
        super(message);
    }

    public ProjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
