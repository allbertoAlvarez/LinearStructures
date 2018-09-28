package dataStructure;

import java.lang.reflect.Array;
import TDA.iHeap;

public class Heap<T extends Comparable<T>> implements iHeap<T> {

	private static final int LENGTH_PREDETERMINED = 10;
	private static final String TYPE_PREDETERMINED = "MAX";
	private static final String MIN = "MIN";

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

	public void IncreaseLength(T type) {
		int length = this.length * 2;
		T[] nuevo = (T[]) Array.newInstance(type.getClass(), length);
		for (int i = 1; i < array.length; i++) {
			nuevo[i] = array[i];
		}

		array = nuevo;
	}

	@Override
	public void add(T newElement) {
		boolean increase = false;
		if (size > array.length - 2) {
			IncreaseLength(newElement);
			increase = true;
		}
		int index = 0;
		index = size + 1;
		array[index] = newElement;
		heapiFy(index);
		size++;
	}

	@Override
	public T root() {
		return array[1];
	}

	@Override
	public T removeRoot() {
		T root = null;
		if (array[1] != null) {

			root = array[1];
			if (size == 1) {
				array[1] = null;
			} else {
				array[1] = array[size];
				array[size] = null;
				heapiDown(1);
			}

			size--;
		}
		return root;

	}

	@Override
	public void heapiDown(int index) {

		int root = index;
		int leftSon = leftSon(index);
		int right = rightSon(index);
		T aux = array[index];

		int x = 0;

		if (type.equals(TYPE_PREDETERMINED)) {
			if (leftSon < size) {
				if (array[leftSon].compareTo(aux) > 0) {
					root = leftSon;
				}
			}
			if (right < size) {
				if (array[right].compareTo(array[root]) > 0) {
					root = right;

				}
			}
		} else if(type.equalsIgnoreCase(MIN)) {
			if (leftSon < size) {
				if (array[leftSon].compareTo(aux) < 0) {
					root = leftSon;
				}
			}
			if (right < size) {
				if (array[right].compareTo(array[root]) < 0) {
					root = right;
				}
			}

		}

		if (root != index) {
			array[index] = array[root];
			array[root] = aux;
//			heapiFy(root);

			if (index == 1) {
				x = root + 1;
				heapiDown(root);

			} else {
				x = index;
				heapiDown(x);
			}

		}
	}

	@Override
	public void heapiFy(int index) {

		int father = father(index);
		T element = array[index];

		if (type.equals(TYPE_PREDETERMINED)) {
			while (index > 1 && array[father].compareTo(element) < 0) {
				array[index] = array[father];
				array[father] = element;
				index = father;
				father = father(index);
			}
		} else if(type.equalsIgnoreCase(MIN)){
			while (index > 1 && array[father(index)].compareTo(element) > 0) {
				array[index] = array[father];
				array[father] = element;
				index = father;
				father = father(index);
			}
		}

	}

	@Override
	public int length() {

		return array.length;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int father(int i) {
		return i / 2;
	}

	@Override
	public int leftSon(int i) {
		return 2 * i;
	}

	@Override
	public int rightSon(int i) {
		return 2 * i + 1;
	}

	public T[] getArray() {
		return array;
	}

	public void setArray(T[] array) {
		this.array = array;
	}

	public static void main(String[] args) {

		Heap<String> h = new Heap<String>(new String());

		h.add("a");
		h.add("b");
		h.add("c");
		h.add("d");
		h.add("e");
		h.add("f");
		h.add("g");
		h.add("h");
		h.add("i");
		h.add("j");
		h.add("k");
		h.add("l");
		h.add("m");
		h.add("n");

		for (int i = 0; i < h.length(); i++) {
			System.out.println(h.getArray()[i]);
		}

		
		
	}

	@Override
	public void deleteIndex(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean invariant(int index) {

		boolean invariant = false;

		int leftSon = leftSon(index);
		int rightSon = rightSon(index);
		if (type == TYPE_PREDETERMINED) {
			invariant = (array[index].compareTo(array[leftSon])) > 0 && (array[index].compareTo(array[rightSon])) > 0;
		} else {
			invariant = (array[index].compareTo(array[leftSon])) < 0 && (array[index].compareTo(array[rightSon])) < 0;
		}
		return invariant;
	}

}
