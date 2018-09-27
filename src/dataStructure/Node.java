package dataStructure;

public class Node<T> {

	private T type;
	private Node<T> nextElement;
	private Node<T> previousElement;
	// private int index;

	public Node(T type) {
		super();
		this.type = type;
		this.nextElement = null;
		this.previousElement = null;
		// this.index = 0;
	}

	public T getType() {
		return type;
	}

	public void setType(T type) {
		this.type = type;
	}

	public Node<T> getNextElement() {
		return nextElement;
	}

	public void setNextElement(Node<T> nextElement) {
		this.nextElement = nextElement;
	}

	// public int getIndex() {
	// return index;
	// }
	//
	// public void setIndex(int index) {
	// this.index = index;
	// }

	public Node<T> getPreviousElement() {
		return previousElement;
	}

	public void setPreviousElement(Node<T> previousElement) {
		this.previousElement = previousElement;
	}

}
