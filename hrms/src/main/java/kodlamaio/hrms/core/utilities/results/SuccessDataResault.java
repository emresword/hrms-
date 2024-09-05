package kodlamaio.hrms.core.utilities.results;

public class SuccessDataResault<T> extends DataResault<T> {

	public SuccessDataResault(T data,String message) {
		super(data, true, message);
		// TODO Auto-generated constructor stub
	}
	public SuccessDataResault(T data) {
		super(true,data);
		// TODO Auto-generated constructor stub
	}
	public SuccessDataResault(String message) {
		super(null, true, message);
		// TODO Auto-generated constructor stub
	}
	public SuccessDataResault() {
		super(true,null);
		// TODO Auto-generated constructor stub
	}

	

}
