package TDA;

import dataStructure.Node;

public interface iHashTable<K,V> {

	public boolean isEmpty();

	public int length();
//
//	public void tableInsert(Node<T> newNode);
//
//	public void tableDelete(int Key);
//
//	public T tableRetrieve(int key);

	public int hashFunction(K key);

	public void clear();
	
	public boolean containKey(K key);
	
	public V get(K key);
	
	public void put(K key, V value);
	
	public void reHash();
	
	public void remove(K key);
	
	
	
}
