package L24_Oct28.GenericClass;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 13-Oct-2018
 *
 */

public class LinkedListGeneric<T> {

	private class Node {
		T data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	// O(1)
	public int size() {
		return this.size;
	}

	// O(1)
	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() {

		System.out.println("----------------------------");

		Node temp = this.head;

		while (temp != null) {

			System.out.print(temp.data + " ");
			temp = temp.next;
		}

		System.out.println(".");
		System.out.println("----------------------------");
	}

	// O(1)
	public T getFirst() throws Exception {

		if (this.size() == 0) {
			throw new Exception("LL is Empty");
		}

		return this.head.data;
	}

	// O(1)
	public T getLast() throws Exception {

		if (this.size() == 0) {
			throw new Exception("LL is Empty");
		}

		return this.tail.data;
	}

	// O(n)
	public T getAt(int k) throws Exception {

		if (this.size() == 0) {
			throw new Exception("LL is Empty");
		}

		if (k < 0 || k >= this.size()) {
			throw new Exception("Invalid Index");
		}

		Node temp = this.head;

		for (int i = 1; i <= k; i++) {
			temp = temp.next;
		}

		return temp.data;

	}

	// O(n)
	private Node getNodeAt(int k) throws Exception {

		if (this.size() == 0) {
			throw new Exception("LL is Empty");
		}

		if (k < 0 || k >= this.size()) {
			throw new Exception("Invalid Index");
		}

		Node temp = this.head;

		for (int i = 1; i <= k; i++) {
			temp = temp.next;
		}

		return temp;

	}

	// O(1)
	public void addLast(T item) {

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		if (this.size > 0)
			this.tail.next = nn;

		// data members update
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.tail = nn;
			this.size++;
		}

	}

	// O(1)
	public void addFirst(T item) {

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		if (this.size > 0)
			nn.next = this.head;

		// summary update
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.head = nn;
			this.size++;
		}

	}

	// O(n)
	public void addAt(T item, int k) throws Exception {

		if (k < 0 || k > this.size()) {
			throw new Exception("Invalid Index");
		}

		if (k == 0) {
			addFirst(item);
		} else if (k == this.size()) {
			addLast(item);
		} else {

			// create a new Node
			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			// set the links
			Node prev = getNodeAt(k - 1);
			Node ahead = prev.next;

			prev.next = nn;
			nn.next = ahead;

			this.size++;

		}

	}

	// O(1)
	public T removeFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		T temp = this.head.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			this.head = this.head.next;
			this.size--;
		}

		return temp;

	}

	// O(n)
	public T removeLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		T temp = this.tail.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {

			Node sm2 = getNodeAt(this.size - 2);
			sm2.next = null;
			this.tail = sm2;
			this.size--;

		}

		return temp;

	}

	// O(n)
	public T removeAt(int k) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		if (k < 0 || k >= this.size) {
			throw new Exception("Invalid Index.");
		}

		if (k == 0) {
			return removeFirst();
		} else if (k == this.size - 1) {
			return removeLast();
		} else {

			Node prev = getNodeAt(k - 1);
			Node self = prev.next;
			Node ahead = self.next;

			// link
			prev.next = ahead;
			this.size--;

			return self.data;
		}
	}

}
