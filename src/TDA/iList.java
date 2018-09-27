package TDA;

import exceptions.NodeNotExistException;
import exceptions.emptyListException;
import dataStructure.Node;

public interface iList<T> {

	public void addFirst(T type);

	public void addEnd(T type);

	public void addBefore(T typeNew, T position) throws NodeNotExistException;

	public void addAfter(T typeNew, T position) throws NodeNotExistException;

	public void addIndex(T typeNew, int index) throws NodeNotExistException;

	public Node<T> removeFirst();

	public Node<T> removeLast();

	public Node<T> removeIndex(int index) throws emptyListException;

	public void deleteFirst() throws emptyListException;

	public void deleteLast() throws emptyListException;

	public void deleteIndex(int index) throws emptyListException;

	public Node<T> searchFirst();

	public Node<T> searchEnd();

	public Node<T> searchIndex(int type);

	public Node<T> contains(T type);

	public boolean isEmpty();

	public int length();

	public void display();

	public Node<T> getHead();

	public Node<T> getEnd();

}
