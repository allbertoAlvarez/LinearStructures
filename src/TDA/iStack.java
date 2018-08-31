package TDA;

import Structure.Node;

public interface iStack<T> {

	public void push(T type);

	public Node<T> pop();

	public boolean isEmpty();
}