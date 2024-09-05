package kodlamaio.hrms.core.utilities.results;

public class ErrorDataResault<T> extends DataResault<T> {
	public ErrorDataResault(T data,  String message) {
		super(data, false, message);
		// TODO Auto-generated constructor stub
	}
	public ErrorDataResault(T data) {
		super(false,data);
		// TODO Auto-generated constructor stub
	}
	public ErrorDataResault(String message) {
		super(null, false, message);
		// TODO Auto-generated constructor stub
	}
	public ErrorDataResault() {
		super(false,null);
		// TODO Auto-generated constructor stub
	}
}
