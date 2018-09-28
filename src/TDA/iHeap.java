package TDA;

public interface iHeap<T extends Comparable<T>> {
	
	public void add(T element );
	
	public T search();
	
	public T remove();
	
	public void heapyDown();
	
	public void heapyUp();
	
	public void heapiFy();
	
	public int length();
	
	public boolean isEmpty();
	
}
