package Exception;

public class NodeNotExistException extends Exception {

	public NodeNotExistException(String message) {
		super("Node: " + message + "does not exist");
	}
}
