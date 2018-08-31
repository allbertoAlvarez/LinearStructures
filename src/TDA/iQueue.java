package TDA;

import Structure.Node;

public interface iQueue<T> {

	public void equeue(T type);

	public Node<T> frond();

	public void dequeue();
}
