package ExceptionHandler;


	public class IdNotFoundException extends Exception{
	    
	    private String message;
	    public IdNotFoundException(String message)
	    {
	        super (message);
	    }


}
