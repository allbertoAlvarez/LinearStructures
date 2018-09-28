package dataStructure;

import java.lang.reflect.Array;
import java.util.Hashtable;
import javax.print.attribute.HashAttributeSet;
import TDA.iHashTable;

public class HashTable<K, V> implements iHashTable<K, V>{

	private final static int LENGTH_PREDETERMINED = 11;
	private SlotHash[] array;
	private int length;
	private int size;
	
	 public HashTable() {
		 array = new SlotHash[LENGTH_PREDETERMINED];
		 size = 0;
		 length = array.length;
	 }
	
	 public HashTable(V classv,int length){
		 array =  new SlotHash[length];
		 size = 0;
		 length = array.length;
	 }

	@Override
	public boolean isEmpty() {
		return (size == 0)?true:false;
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public int hashFunction(K key) {
		return key.hashCode() % array.length;
	}

	@Override
	public void clear() {
		for (int i = 0; i < array.length; i++) {
			array[i] = null;
		}	
	}

	@Override
	public boolean containKey(K key) {
		boolean contain = false;
		int index = hashFunction(key);
		if(array[index]!= null) {
			contain = true;
		}
		return contain;
	}

	@Override
	public V get(K key) {
		int i = hashFunction(key);
		return (V) array[i].getValue();
	}

	@Override
	public void put(K key, V value) {
		
		int i = hashFunction(key);
		boolean aggregate = false;
		
		if(containKey(key)) {
			array[i].setValue(value); 
		}else {
			if(array[i] == null) {
				array[i] = new SlotHash<K, V>(key, value);
				size++;
				aggregate =true;
			}else {
				int k = 1;
				int j = (int) (i+Math.pow(2,k));
				for (; j < array.length && !aggregate; k++) {
					if(array[j] == null) {
						array[j] = new SlotHash<K, V>(key, value);
						size++;
						aggregate =true;
					}else {
						j = j + (int) Math.pow(2, k);							
					}		
				}		
				if(!aggregate) {
					reHash();
					put(key, value);
				}
			}	
		}	
	}
	
	@Override
	public void reHash() {
		SlotHash<K, V>[] newArray = new SlotHash[length*2];
		SlotHash<K, V>[] copy = array.clone();
		array = newArray;
		for (int i = 0; i < copy.length; i++) {	
			if(copy[i]!= null) {
				put(copy[i].getKey(), copy[i].getValue());				
			}
		}
	}

	@Override
	public void remove(K key) {
		int index = hashFunction(key);
		array[index] = null;
		
	}
	
	
	public SlotHash<K, V>[] getArray() {
		return array;
	}


	public static void main(String[] args) {
		HashTable<String, Long> h = new HashTable<>();
		
		h.put("a", new Long(1));
		h.put("b", new Long(2));
		h.put("c", new Long(3));
		h.put("d", new Long(4));
		h.put("e", new Long(5));
		h.put("a", new Long(4));
		
		for (int i = 0; i < h.getArray().length; i++) {
			if(h.getArray()[i] != null) {
				System.out.println(h.getArray()[i].getKey() + " - " + h.getArray()[i].getValue() );				
			}else {
				System.out.println(h.getArray()[i]);
			}
		}
			
	}

	 
	 
	

	
}
