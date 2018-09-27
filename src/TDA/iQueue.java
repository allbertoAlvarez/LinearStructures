package TDA;

import dataStructure.Node;

public interface iQueue<T> {

	public void equeue(T type);

	public Node<T> front();

	public Node<T> dequeue();

	public boolean isEmpty();

	public int length();

}
