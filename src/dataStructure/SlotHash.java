package dataStructure;

public class SlotHash <K,V>{

	private V value;
	private K key;
	
	
	public SlotHash( K key, V value) {
		this.value = value;
		this.key = key;
		
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}
	
	

	
}
