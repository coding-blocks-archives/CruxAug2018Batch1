package L15_Oct7;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Oct-2018
 *
 */

public class QueueClient {

	public static void main(String[] args) throws Exception {

		Queue q = new Queue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(60);
		q.enqueue(70);
		// q.enqueue(80);
		q.display();
	}

}
