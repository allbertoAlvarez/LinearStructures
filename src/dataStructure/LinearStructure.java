package dataStructure;

import exceptions.NodeNotExistException;
import exceptions.emptyListException;
import TDA.iList;
import TDA.iQueue;
import TDA.iStack;

public class LinearStructure<T> implements iStack<T>, iList<T>, iQueue<T> {

	private Node<T> head;
	private Node<T> end;
	private int length;

	public LinearStructure() {
		super();
		this.head = null;
		this.end = null;
		this.length = 0;

	}
	
	@Override
	public void addFirst(T type) {
		Node<T> newNode = new Node<T>(type);

		if (this.isEmpty()) {

			this.head = newNode;
			this.end = newNode;
			length++;
		} else {

			newNode.setPreviousElement(null);
			newNode.setNextElement(head);
			head.setPreviousElement(newNode);
			head = newNode;
			this.length++;
		}

	}

	@Override
	public void addEnd(T type) {

		Node<T> newNode = new Node<T>(type);

		if (this.isEmpty()) {
			this.head = newNode;
			this.end = newNode;
			length++;
			
		} else {
			newNode.setNextElement(null);
			newNode.setPreviousElement(end);
			end.setNextElement(newNode);
			end = newNode;
			length++;
			
		}

	}

	@Override
	public void addBefore(T typeNew, T typePosition) throws NodeNotExistException {
		Node<T> newNode = new Node<T>(typeNew);

		Node<T> searched = contains(typePosition);

		if (searched != null) {

			if (searched == head) {
				addFirst(typeNew);
			} else {
				newNode.setNextElement(searched);
				newNode.setPreviousElement(searched.getPreviousElement());
				searched.getPreviousElement().setNextElement(newNode);
				searched.setPreviousElement(newNode);
			}
			length++;

		} else {
			throw new NodeNotExistException(typePosition.toString());
		}

	}

	@Override
	public void addAfter(T typeNew, T typePosition) throws NodeNotExistException {
		Node<T> newNode = new Node<T>(typeNew);
		Node<T> searched = contains(typePosition);

		if (searched != null) {
			if (searched == end) {
				addEnd(typeNew);
			} else {
				newNode.setPreviousElement(searched);
				newNode.setNextElement(searched.getNextElement());
				searched.getNextElement().setPreviousElement(newNode);
				searched.setNextElement(newNode);
			}
			length++;
		} else {
			throw new NodeNotExistException(typePosition.toString());
		}
	}

	@Override
	public void addIndex(T typeNew, int index) throws NodeNotExistException {
		Node<T> searched = searchIndex(index);
		if (searched != null) {
			addBefore(typeNew, searched.getType());
		}
	}

	@Override
	public Node<T> removeFirst() {
		Node<T> aux = head;

		if (head.getNextElement() != null) {
			this.head.getNextElement().setPreviousElement(null);
			head = head.getNextElement();
		} else {
			head = null;
		}

		aux.setNextElement(null);
		aux.setPreviousElement(null);

		length--;
		return aux;
	}

	@Override
	public Node<T> removeLast() {
		Node<T> aux = end;
		if (end.getPreviousElement() != null) {
			this.end.getPreviousElement().setNextElement(null);
			end = end.getPreviousElement();
		} else {
			end = null;
		}

		aux.setNextElement(null);
		aux.setPreviousElement(null);

		length--;
		return aux;
	}

	@Override
	public Node<T> removeIndex(int index) throws emptyListException {
		Node<T> aux = null;
		if (!this.isEmpty() && index < length) {
			aux = head;
			int x = 0;
			while (aux != null && x < index) {
				x++;
				aux = aux.getNextElement();
			}

			if (aux == head) {
				head = head.getNextElement();
				if (head != null) {
					head.setPreviousElement(null);
				}
			} else if (aux == end) {
				end = end.getPreviousElement();
				end.setNextElement(null);
			} else {
				aux.getPreviousElement().setNextElement(aux.getNextElement());
				aux.getNextElement().setPreviousElement(aux.getPreviousElement());
			}

			length--;

		} else {
			throw new emptyListException("index", index + "");
		}

		aux.setNextElement(null);
		aux.setPreviousElement(null);

		return aux;
	}

	@Override
	public void deleteFirst() throws emptyListException {

		if (head != null && end != null) {
			if (length == 1) {
				head = null;
				end = null;
			} else {
				this.head.getNextElement().setPreviousElement(null);
				head = head.getNextElement();
			}
			length--;
		} else {
			throw new emptyListException("node", "first node");
		}

	}

	@Override
	public void deleteLast() throws emptyListException {

		if (head != null && end != null) {
			if (length == 1) {
				head = null;
				end = null;
			} else {
				this.end.getPreviousElement().setNextElement(null);
				end = end.getPreviousElement();
			}
			length--;
		} else {
			throw new emptyListException("node", "first node");
		}
	}

	@Override
	public void deleteIndex(int index) throws emptyListException {
		Node<T> aux = null;
		if (!this.isEmpty() && index < length) {
			aux = head;
			int x = 0;
			while (aux != null && x < index) {
				x++;
				aux = aux.getNextElement();
			}

			if (aux == head) {
				deleteFirst();
			} else if (aux == end) {
				deleteLast();
			} else {
				aux.getPreviousElement().setNextElement(aux.getNextElement());
				aux.getNextElement().setPreviousElement(aux.getPreviousElement());
			}

			length--;
		} else {
			throw new emptyListException("index", index + "");
		}

	}

	@Override
	public Node<T> searchFirst() {
		return head;
	}

	@Override
	public Node<T> searchEnd() {
		return end;
	}

	@Override
	public Node<T> searchIndex(int index) {

		Node<T> searched = head;
		int x = 0;

		while (searched != null && x < index) {
			searched = searched.getNextElement();
			x++;
		}

		return searched;
	}

	@Override
	public Node<T> contains(T type) {
		Node<T> searched = head;
		while (searched != null && searched.getType() != type) {
			searched = searched.getNextElement();
		}
		return searched;
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

	// Encolar
	@Override
	public void equeue(T type) {
		Node<T> newNode = new Node<T>(type);

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
		if (first != null) {
			head = head.getNextElement();
			length--;
		}
		return first;
	}

	@Override
	public void push(T type) {
		Node<T> newNode = new Node<T>(type);

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
		if (firstNode != null) {
			end = end.getPreviousElement();
			length--;
		}
		return firstNode;
	}

	@Override
	public Node<T> top() {

		Node aux;
		if (isEmpty()) {
			aux = null;
		} else {
			aux = end;
		}
		return aux;
	}

	@Override
	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	@Override
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

	// public static void main(String[] args) {
	// // iStack<String> list = new AlbertList<String>();
	//
	// // list.addEnd("1");
	// // list.addEnd("2");
	// // list.addEnd("3");
	// // list.addEnd("4");
	// // list.addEnd("5");
	// // list.addEnd("6");
	// // list.addEnd("7");
	// // list.addEnd("8");
	// //
	// // list.addFirst("0");
	// //
	// // list.addAfter("7.5", "7");
	// // list.addBefore("6.5", "7");
	// // list.addIndex("1.5", 3);
	// //
	// // list.deleteFirst();
	// // list.deleteLast();
	// // list.deleteIndex(6);
	// //
	// // System.out.println("remove : " + list.removeIndex(2).getType());
	// //
	// // list.display();
	//
	// }

}
