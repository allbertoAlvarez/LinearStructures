package TDA;

import dataStructure.Node;

public interface iStack<T> {

	public void push(T type);

	public Node<T> pop();

	public boolean isEmpty();

	public int length();

	public Node<T> top();
}
