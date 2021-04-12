package login.com.exception;

@SuppressWarnings("serial")
public class EmployeeExitsException   extends RuntimeException 
{
public EmployeeExitsException(String errorMessage) {
	super(errorMessage);
}
}
