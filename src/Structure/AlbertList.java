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

	// Encolar
	@Override
	public void equeue(T type) {
		Node<T> newNode = new Node<T>(type, length);

		if (this.isEmpty()) {
			this.head = newNode;
			this.end = newNode;
			length = 1;
		} else {
			this.end.setNextElement(newNode);
			this.end = newNode;
			this.length++;
		}

	}

	@Override
	public Node<T> front() {
		return head;
	}

	// Desencolar
	@Override
	public Node<T> dequeue() {
		Node<T> first = null;
		first = head;
		head = head.getNextElement();

		length--;
		return first;
	}

	@Override
	public void push(T type) {
		Node<T> newNode = new Node<T>(type, length);

		if (end == null) {
			// head = newNode;
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
		return length;
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
		if (!this.isEmpty()) {
			Node<T> aux = head;
			while (aux != null) {

				if (length == 1 && head.getIndex() == index) {
					head = null;
					end = null;
				}
				if (aux.getIndex() == index) {
					aux.getPreviousElement().setNextElement(aux.getNextElement());
					aux.getNextElement().setPreviousElement(aux.getPreviousElement());
				}
				aux = aux.getNextElement();
			}

		}
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
