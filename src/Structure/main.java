package Structure;

import TDA.iQueue;

public class main {

	public static void main(String[] args) {

		iQueue<Integer> queue = new AlbertList<Integer>();

		// for (int i = 0; i < 10; i++) {
		queue.equeue(1);
		// }

		// for (int i = 0; i < 10; i++) {
		int first = queue.dequeue().getType();
		// }

	}
}
