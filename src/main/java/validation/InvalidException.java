
package validation;



public class InvalidException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String message;
	 
public InvalidException( String message) {
	
	this.message=message;
}
	
	public String getmessage() {
		return message;
	}
}
