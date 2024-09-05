package kodlamaio.hrms.core.utilities.results;

public class DataResault<T> extends Resault{
    private T data;
    
	public DataResault(T data,boolean success, String message) {
		super(success, message);
		this.data=data;
		// TODO Auto-generated constructor stub
	}

	public DataResault(boolean success, T data) {
		super(success);
		this.data = data;
	}

	public T getData() {
		return this.data;
	}

	

}
