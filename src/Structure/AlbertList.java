package Structure;

import TDA.iList;
import TDA.iQueue;
import TDA.iStack;

public class AlbertList<T> implements iList<T>, iStack<T>, iQueue<T> {

	private Node<T> head;
	private Node<T> end;
	private int length;

	public AlbertList() {
		super();
		this.head = null;
		this.end = null;
		this.length = 0;
	}

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public Node<T> getEnd() {
		return end;
	}

	public void setEnd(Node<T> end) {
		this.end = end;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public void equeue(T type) {
		// TODO Auto-generated method stub

	}

	@Override
	public Node<T> frond() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dequeue() {
		// TODO Auto-generated method stub

	}

	@Override
	public void push(T type) {
		Node<T> newNode = new Node<T>(type, length);

		if (end == null) {
			head = newNode;
			end = newNode;
			length++;
		} else {

			newNode.setPreviousElement(end);
			end = newNode;
			length++;
		}
	}

	@Override
	public Node<T> pop() {
		Node<T> firstNode = end;
		end = end.getPreviousElement();
		length--;
		return firstNode;
	}

	@Override
	public void add(T type) {
		Node<T> newNode = new Node<T>(type, length);

		if (this.isEmpty()) {

			this.head = newNode;
			this.end = newNode;
			// end.setPreviousElement(newNode);

			length = 1;
		} else {

			this.end.setNextElement(newNode);
			newNode.setPreviousElement(end);
			this.end = newNode;
			this.length++;
		}

	}

	@Override
	public boolean isEmpty() {
		return this.length == 0;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void display() {

		Node aux = head;

		while (aux != null) {
			System.out.println(aux.getType());
			aux = aux.getNextElement();
		}

	}

	@Override
	public void removeIndex(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeFirst() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeLast() {

		this.end.getPreviousElement().setNextElement(null);
		end = end.getPreviousElement();
		length--;

	}

}
