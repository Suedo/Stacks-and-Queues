import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
	private int size;
	private Node head, tail;

	private class Node {
		Item item;
		Node next;
		Node prev;
	}

	public Deque() {
		head = new Node();
		head.next = null;
		head.prev = null;
		head.item = null;
		tail = head;
	}

	public boolean isEmpty() {
		return tail == head;
	}

	public int size() {
		return size;
	}

	public void addFirst(Item item) {

		if (item == null)
			throw new java.lang.NullPointerException(
					" adding null values is not allowed ");
		else {
			Node newNode = new Node();
			newNode.prev = null;
			newNode.next = head;
			head.item = item;
			head.prev = newNode;
			head = newNode;
			size++;
		}

	}

	public void addLast(Item item) {

		if (item == null)
			throw new java.lang.NullPointerException(
					" adding null values is not allowed ");
		else {
			Node oldTail = tail;
			tail = new Node();
			tail.item = item;
			tail.next = null;
			tail.prev = oldTail;
			oldTail.next = tail;
			size++;
		}

	}

	public Item removeFirst() {
		if (isEmpty())
			throw new java.util.NoSuchElementException(
					" cannot remove from an empty deque");

		else {
			Item item = head.next.item;
			head = head.next;
			head.prev = null;
			size--;
			return item;
		}
	}

	public Item removeLast() {
		if (isEmpty())
			throw new java.util.NoSuchElementException(
					" cannot remove from an empty deque");

		else {
			Item item = tail.item;
			tail = tail.prev;
			tail.next = null;
			size--;
			return item;
		}
	}

	// implementing the inherited abstract method from the Iterable<Item>
	// interface
	public Iterator<Item> iterator() { // iterator() is the name of the method

		return new Iterator<Item>() {

			private Node current = head.next; // head points to the location
												// next enqueue will occur,

			// so actual head(containing values) will be from head.next

			public boolean hasNext() {
				return current != null;
			}

			public void remove() {
				throw new UnsupportedOperationException(
						"remove is illegal to use as per the API");
			}

			public Item next() {

				Item temp = current.item;
				current = current.next;
				return temp;
			}
		};
	}
	public static void main(String[] args){
		Deque<String> t = new Deque<String>();
		t.addFirst("d");
		t.addFirst("c");
		t.addFirst("b");
		t.addFirst("a");
		t.removeLast();
		t.removeLast();
		t.addLast("e");
		t.addLast("f");
		t.removeFirst();
		t.removeFirst();
		t.addFirst("h");
		t.addFirst("g");

		for (String s : t) {
			System.out.println(s);
		}
	
	}

}
