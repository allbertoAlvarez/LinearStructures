package exceptions;

public class emptyListException extends Exception {

	public emptyListException(String type, String message) {
		super("The" + type + "can not be accessed: " + message + ", the list is empty");
	}

}
