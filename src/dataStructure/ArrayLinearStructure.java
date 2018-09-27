package dataStructure;

import java.lang.reflect.Array;

import TDA.iHash;

public class ArrayLinearStructure<T> implements iHash<T> {

	T[] array;

	@SuppressWarnings("unchecked")
	public ArrayLinearStructure(T c , int length) {
		array = (T[]) Array.newInstance(c.getClass(), length);
	}
	
	public T[] getArray() {
		return (T[]) array;
	}

	@Override
	public boolean isEmpty() {
		
		boolean empty = false;
		for (int i = 0; i < array.length; i++) {
			empty = array[i] == null;
		}
	
		return empty;
	}
	

	@Override
	public int length() {
		return array.length;
	}

	@Override
	public void tableInsert(Node<T> newNode) {
		
	}

	@Override
	public void tableDelete(int key) {
		array[hashFunction(key)] = null;
	}

	@Override
	public T tableRetrieve(int key) {
		
		return  (T) array[hashFunction(key)];
	}

	@Override
	public int hashFunction(int key) {
		return key % length();
		
	}
	
	public void agregar(LinearStructure c) {
		array[0] = (T) c;
	}

}
