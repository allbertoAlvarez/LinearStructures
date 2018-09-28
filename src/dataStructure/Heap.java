package dataStructure;

import java.lang.reflect.Array;
import java.security.AlgorithmParameterGenerator;

import TDA.iHeap;


public class Heap<T extends Comparable<T>> implements iHeap<T>{

	private static final int LENGTH_PREDETERMINED = 10;
	private static final String TYPE_PREDETERMINED = "MAX";
	
	private int size;
	private T[] array;
	private int length;
	private String type;
	
	
	public Heap(T classT) {
		array = (T[]) Array.newInstance(classT.getClass(), LENGTH_PREDETERMINED);
		length = LENGTH_PREDETERMINED;
		size = 0;
		type = TYPE_PREDETERMINED;
	}
	
	public Heap(T classT, String type) {
		array = (T[]) Array.newInstance(classT.getClass(), LENGTH_PREDETERMINED);
		length = LENGTH_PREDETERMINED;
		size = 0;
		this.type = type;
	}
	
	public Heap(T classT, int length) {
		array = (T[]) Array.newInstance(classT.getClass(), length);
		length = length;
		size = 0;
		this.type = TYPE_PREDETERMINED;
	}
	
	public Heap(T classT, int length, String type) {
		array = (T[]) Array.newInstance(classT.getClass(), length);
		length = length;
		size = 0;
		this.type = type;
	}
	
	
	
	@Override
	public void add(T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T search() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void heapyDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void heapyUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void heapiFy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	
	
	

}
