package test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import dataStructure.LinearStructure;
import dataStructure.Node;
import exceptions.NodeNotExistException;
import exceptions.emptyListException;
import TDA.iList;
import TDA.iQueue;
import TDA.iStack;

class testAlbertList {

	iList<String> list;
	iQueue<String> queue;
	iStack<String> stack;

	String a;
	String b;
	String c;
	String d;
	String e;
	String f;

	private void setupStage1() {
		list = new LinearStructure<String>();
		a = "a";
		b = "b";
		c = "c";
		d = "d";
		e = "e";
		f = "f";

	}

	private void setupStage2() {
		stack = new LinearStructure<String>();

		a = "a";
		b = "b";
		c = "c";
		d = "d";
		e = "e";
		f = "f";
	}

	private void setupStage3() {
		queue = new LinearStructure<String>();

		a = "a";
		b = "b";
		c = "c";
		d = "d";
		e = "e";
		f = "f";
	}

	@Test
	void testAddFirst() {
		setupStage1();
		String keyWord = "";
		for (int i = 0; i < 10; i++) {
			keyWord = "object" + i;
			list.addFirst(keyWord);
		}
		Node first = list.getHead();
		for (int i = 9; i > 0; i--) {
			assertTrue(first.getType().equals("object" + i));
			first = first.getNextElement();
		}
	}

	@Test
	void testAddEnd() {
		setupStage1();
		String keyWord = "";
		for (int i = 0; i < 10; i++) {
			keyWord = "object" + i;
			list.addEnd(keyWord);
		}
		Node first = list.getHead();
		for (int i = 0; i < 10; i++) {
			assertTrue(first.getType().equals("object" + i));
			first = first.getNextElement();
		}
	}

	@Test
	void testAddBefore() {
		setupStage1();

		list.addEnd(b);
		list.addEnd(d);
		list.addEnd(f);

		try {
			list.addBefore(a, b);
			list.addBefore(c, d);
			list.addBefore(e, f);
		} catch (NodeNotExistException e1) {
			e1.printStackTrace();
		}

		boolean test = true;

		Node first = list.getHead();
		for (int i = 0; i < 5; i++) {
			char letter = (char) (97 + i);
			assertTrue(first.getType().equals(letter + ""));
			first = first.getNextElement();
		}

	}

	@Test
	void testAddAfter() {
		setupStage1();

		list.addEnd(a);
		list.addEnd(c);
		list.addEnd(e);

		try {
			list.addAfter(b, a);
			list.addAfter(d, c);
			list.addAfter(f, e);
		} catch (NodeNotExistException e1) {

			e1.printStackTrace();
		}

		boolean test = true;

		Node first = list.getHead();
		for (int i = 0; i < 5; i++) {
			char letter = (char) (97 + i);
			assertTrue(first.getType().equals(letter + ""));
			first = first.getNextElement();
		}
	}

	@Test
	void testAddIndex() { // indice no exista
		setupStage1();

		list.addEnd(a);// 0
		list.addEnd(c);// 1
		list.addEnd(e);// 2

		try {
			list.addIndex(b, 1);
			list.addIndex(d, 3);
			list.addIndex(f, 5);
		} catch (NodeNotExistException e1) {

			e1.printStackTrace();
		}

		Node first = list.getHead();
		for (int i = 0; i < 5; i++) {
			char letter = (char) (97 + i);
			assertTrue(first.getType().equals(letter + ""));
			first = first.getNextElement();
		}

	}

	// remover los otros nodos
	@Test
	void testRemoveFirst() { // probar cuando no exista o no haya nada
		setupStage1();

		boolean test = true;

		list.addEnd(a);
		list.addEnd(b);
		list.addEnd(c);
		list.addEnd(d);

		test = test && (list.removeFirst().getType().equals(a));
		test = test && (list.removeFirst().getType().equals(b));
		test = test && (list.removeFirst().getType().equals(c));
		test = test && (list.removeFirst().getType().equals(d));

		assertTrue(test);

	}

	// remover los otros nodos
	@Test
	void testRemoveLast() {
		setupStage1();

		boolean test = true;

		list.addEnd(a);
		list.addEnd(b);
		list.addEnd(c);
		list.addEnd(d);

		test = test && (list.removeLast().getType().equals(d));
		test = test && (list.removeLast().getType().equals(c));
		test = test && (list.removeLast().getType().equals(b));
		test = test && (list.removeLast().getType().equals(a));

		assertTrue(test);

	}

	// remover los otros nodos
	@Test
	void testRemoveIndex() {
		setupStage1();

		boolean test = true;

		list.addEnd(a);// 0 -
		list.addEnd(b);// 1
		list.addEnd(c);// 2-
		list.addEnd(d);// 3

		try {
			test = test && (list.removeIndex(3).getType().equals(d));
			test = test && (list.removeIndex(2).getType().equals(c));
			test = test && (list.removeIndex(1).getType().equals(b));
			test = test && (list.removeIndex(0).getType().equals(a));
		} catch (emptyListException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		list.addEnd(a);// 0 -
		list.addEnd(b);// 1
		list.addEnd(c);// 2-
		list.addEnd(d);// 3

		try {
			test = test && (list.removeIndex(0).getType().equals(a));
			test = test && (list.removeIndex(0).getType().equals(b));
			test = test && (list.removeIndex(0).getType().equals(c));
			test = test && (list.removeIndex(0).getType().equals(d));
		} catch (emptyListException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		list.addEnd(a);// 0 -
		list.addEnd(b);// 1
		list.addEnd(c);// 2-
		list.addEnd(d);// 3

		try {
			test = test && (list.removeIndex(0).getType().equals(a));
			test = test && (list.removeIndex(1).getType().equals(c));
			test = test && (list.removeIndex(1).getType().equals(d));
			test = test && (list.removeIndex(0).getType().equals(b));
		} catch (emptyListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue(test);

	}

	@Test
	void testDeleteFirst() { // probar cuando no exista o no haya nada
		setupStage1();

		boolean test = true;

		list.addEnd(a);
		list.addEnd(b);
		list.addEnd(c);
		list.addEnd(d);

		try {
			list.deleteFirst();
		} catch (emptyListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test = test && list.getHead().getType().equals(b);

		try {
			list.deleteFirst();
		} catch (emptyListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test = test && list.getHead().getType().equals(c);

		try {
			list.deleteFirst();
		} catch (emptyListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test = test && list.getHead().getType().equals(d);

		assertTrue(test);

	}

	@Test
	void testDeleteLast() { // probar cuando no exista o no haya nada
		setupStage1();

		boolean test = true;

		list.addEnd(a);
		list.addEnd(b);
		list.addEnd(c);
		list.addEnd(d);

		try {
			list.deleteLast();
		} catch (emptyListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test = test && list.getEnd().getType().equals(c);
		try {
			list.deleteLast();
		} catch (emptyListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test = test && list.getEnd().getType().equals(b);

		try {
			list.deleteLast();
		} catch (emptyListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test = test && list.getEnd().getType().equals(a);

		// list.deleteLast();// evaluar cuando no exista nada

		assertTrue(test);

	}

	@Test
	void testDeleteIndex() { // probar cuando no exista o no haya nada
		setupStage1();

		list.addEnd(a);// 0 //0 //0 //0
		list.addEnd(d);// 1
		list.addEnd(b);// 2 //1 //1 //1
		list.addEnd(e);// 3 //2
		list.addEnd(c);// 4 //3 //2 //2
		list.addEnd(f);// 5 //4 //3

		try {
			list.deleteIndex(1);
			list.deleteIndex(2);
			list.deleteIndex(3);
		} catch (emptyListException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Node aux = list.getHead();
		for (int i = 0; i < 2; i++) {
			char letter = (char) (97 + i);
			assertTrue(aux.getType().equals(letter + ""));
			aux = aux.getNextElement();
		}

	}

	@Test
	void testSearchFirst() {
		setupStage1();

		boolean test = true;

		list.addEnd(a);
		list.addEnd(d);
		list.addEnd(b);
		list.addEnd(e);
		list.addEnd(c);
		list.addEnd(f);

		assertTrue(list.searchFirst().getType().equals(a));

		try {
			list.deleteFirst();
			list.deleteFirst();
		} catch (emptyListException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		assertTrue(list.searchFirst().getType().equals(b));

		try {
			list.deleteFirst();
			list.deleteFirst();
			list.deleteFirst();
		} catch (emptyListException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		assertTrue(list.searchFirst().getType().equals(f));

	}

	@Test
	void testSearchEnd() {
		setupStage1();

		boolean test = true;

		list.addEnd(a);
		list.addEnd(d);
		list.addEnd(b);
		list.addEnd(e);
		list.addEnd(c);
		list.addEnd(f);

		assertTrue(list.searchEnd().getType().equals(f));

		try {
			list.deleteLast();
			list.deleteLast();
		} catch (emptyListException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		assertTrue(list.searchEnd().getType().equals(e));

		try {
			list.deleteLast();
			list.deleteLast();
			list.deleteLast();
		} catch (emptyListException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		assertTrue(list.searchEnd().getType().equals(a));

	}

	@Test
	void TestSearchIndex() {
		setupStage1();

		boolean test = true;

		list.addEnd(a);// 0
		list.addEnd(d);// 1
		list.addEnd(b);// 2
		list.addEnd(e);// 3
		list.addEnd(c);// 4
		list.addEnd(f);// 5

		test = test && (list.searchIndex(0).getType().equals(a));
		test = test && (list.searchIndex(2).getType().equals(b));
		test = test && (list.searchIndex(5).getType().equals(f));
		test = test && (list.searchIndex(4).getType().equals(c));

		assertTrue(test);

	}

	@Test
	void testContains() {
		setupStage1();

		boolean test = true;

		list.addEnd(a);// 0
		list.addEnd(d);// 1
		list.addEnd(b);// 2
		list.addEnd(e);// 3
		list.addEnd(c);// 4
		list.addEnd(f);// 5

		test = test && (list.contains(a).getType().equals(a));
		test = test && (list.contains(b).getType().equals(b));
		test = test && (list.contains(f).getType().equals(f));
		test = test && (list.contains(c).getType().equals(c));

		assertTrue(test);

	}

	@Test
	void testIsEmpty() {
		setupStage1();

		assertTrue(list.isEmpty());

		list.addEnd(a);// 0
		list.addEnd(d);// 1
		list.addEnd(b);// 2
		list.addEnd(e);// 3
		list.addEnd(c);// 4
		list.addEnd(f);// 5

		assertTrue(!list.isEmpty());

		try {
			list.deleteLast();
			list.deleteLast();
			list.deleteLast();
			list.deleteLast();
			list.deleteLast();
			list.deleteLast();
		} catch (emptyListException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		assertTrue(list.isEmpty());
	}

	@Test
	void testLength() {
		setupStage1();

		list.addEnd(a);// 0
		list.addEnd(d);// 1

		assertTrue(list.length() == 2);

		list.addEnd(b);// 2
		list.addEnd(e);// 3

		assertTrue(list.length() == 4);

		try {
			list.deleteLast();
		} catch (emptyListException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // 4

		assertTrue(list.length() == 3);

	}

	@Test
	void testPush() {
		setupStage2();

		stack.push(a);
		assertTrue(stack.top().getType().equals(a));

		stack.push(b);
		stack.push(c);
		assertTrue(stack.top().getType().equals(c));

		stack.push(d);
		stack.push(e);
		stack.push(f);
		assertTrue(stack.top().getType().equals(f));

	}

	@Test
	void testPop() {
		setupStage2();

		stack.push(a);
		stack.push(b);
		stack.push(c);
		stack.push(d);
		stack.push(e);
		stack.push(f);

		for (int i = 0; i < 5; i++) {
			char letter = (char) (102 - i);
			assertTrue(stack.pop().getType().equals(letter + ""));
		}

	}

	@Test
	void testTop() {
		setupStage2();

		stack.push(a);
		stack.push(b);
		stack.push(c);
		stack.push(d);
		stack.push(e);
		stack.push(f);

		assertTrue(stack.top().getType().equals(f));

		stack.pop();
		stack.pop();

		assertTrue(stack.top().getType().equals(d));

		stack.pop();
		assertTrue(stack.top().getType().equals(c));

		stack.pop();
		assertTrue(stack.top().getType().equals(b));

	}

	@Test
	void testEqueue() {
		setupStage3();

		boolean test = true;

		queue.equeue(a);
		queue.equeue(b);
		queue.equeue(c);
		queue.equeue(d);
		queue.equeue(f);
		queue.equeue(e);

		test = test && (queue.length() == 6);
		test = test && queue.front().getType().equals(a);

		assertTrue(test);

	}

	@Test
	void testFront() {
		setupStage3();

		queue.equeue(a);
		queue.equeue(b);
		queue.front().getType().equals(a);

		queue.equeue(c);
		queue.equeue(d);
		queue.front().getType().equals(a);

		queue.equeue(f);
		queue.front().getType().equals(a);

		queue.equeue(e);
		queue.front().getType().equals(a);

	}

	@Test
	void testDequeue() {
		setupStage3();

		boolean test = true;

		queue.equeue(a);
		queue.equeue(b);
		queue.equeue(c);
		queue.equeue(d);
		queue.equeue(f);
		queue.equeue(e);

		test = test && queue.dequeue().getType().equals(a);
		test = test && queue.dequeue().getType().equals(b);
		test = test && queue.dequeue().getType().equals(c);
		test = test && queue.dequeue().getType().equals(d);
		test = test && queue.dequeue().getType().equals(e);
		test = test && queue.dequeue().getType().equals(f);

	}

}
