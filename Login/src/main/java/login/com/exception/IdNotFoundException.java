package login.com.exception;

@SuppressWarnings("serial")
public class IdNotFoundException extends RuntimeException {
public IdNotFoundException(String errorMessage) {
	super(errorMessage);
}
}
