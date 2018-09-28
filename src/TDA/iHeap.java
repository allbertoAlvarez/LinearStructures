package TDA;

public interface iHeap<T extends Comparable<T>> {
	
	public void add(T element );
	
	public T removeRoot();
	
	public void deleteIndex(int index);
	
	public void heapiDown(int index);
	
	public T root();
	
	public void heapiFy(int index);
	
	public int length();
	
	public boolean isEmpty();
	
	public int father(int index);
	
	public int leftSon(int index);
	
	public int rightSon(int index);
	
	public boolean invariant(int index);
		
	
}
