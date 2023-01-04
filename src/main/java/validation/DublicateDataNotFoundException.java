package validation;

public class DublicateDataNotFoundException  extends Exception {
	private static final long serialVersionUID = 1L;

	private String message;

	public DublicateDataNotFoundException(String message) {

		this.message = message;
	}

	public String getmessage() {
		return message;
	}
}

