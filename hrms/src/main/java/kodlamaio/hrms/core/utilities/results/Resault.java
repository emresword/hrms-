package kodlamaio.hrms.core.utilities.results;

public class Resault {
	private boolean success;
    private String message;
    
	public Resault(boolean success) {
	
		this.success = success;
	}
	public Resault(boolean success, String message) {
	
		this(success);
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public String getMessage() {
		return message;
	}
	  
}
