import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

	private int size;
	private Node head, tail;

	private class Node {
		Item item;
		Node next;
		Node prev;
	}
	
	@SuppressWarnings("unchecked")
	Node[] nd = (Node[]) new Object[100];
	
	public RandomizedQueue() {
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

	public void enqueue(Item item) {
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
			nd[size++] = tail;
		}
	}

	private Node getRanPointer() {
		int ran = 1 + StdRandom.uniform(size); // since head is a sentinel, so
												// actual database starts after
												// head , hence 1 is added
		Node pointer = head.next;
		for (int i = 1; i < ran; i++) { // as data starts from index 1 instead
										// of index 0 (which denotes the head)
			pointer = pointer.next;
		}
		return pointer;
	}

	public Item dequeue() {
		if (isEmpty())
			throw new java.util.NoSuchElementException(
					" cannot remove from an empty deque");
		else {
			Node pointer = getRanPointer();
			Item item;

			if (pointer == head) {
				item = head.item;
				head = head.next;
				head.prev = null;
				size--;
			} else if (pointer == tail) {
				item = tail.item;
				tail = tail.prev;
				tail.next = null;
				size--;
			} else {
				item = pointer.item;
				pointer.prev.next = pointer.next;
				pointer.next.prev = pointer.prev;
				pointer = null; // deletes the pointer 
				size--;
			}
			return item;
		}
	}

	public Item sample() {
		if (isEmpty())
			throw new java.util.NoSuchElementException(
					" cannot remove from an empty deque");
		else {
			Node pointer = getRanPointer();
			return pointer.item;
		}
	}

	@Override
	public Iterator<Item> iterator() {

		return new Iterator<Item>() {

			private Node current = head.next;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public Item next() {
				if(current == null)
					throw new java.util.NoSuchElementException("no more items to iterate");
				Item temp = current.item;
				current = current.next;
				return temp;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException(
						"remove is illegal to use as per the API");
			}

		};
	}
}
