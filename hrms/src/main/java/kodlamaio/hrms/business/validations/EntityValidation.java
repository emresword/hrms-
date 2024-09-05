package kodlamaio.hrms.business.validations;



public interface EntityValidation<T>{
	public boolean validate(T entity);
}
