package doubleendedqueues;

public class DoubleEndedQueue implements DoubleEndedQueueInterface{
	private static class Node{
		int value;
		Node next = null;
		Node previous = null;
	}
	private Node head, tail;
	private int size;
	
	public DoubleEndedQueue() {
		this.head = null;
		this.tail = null;
		size = 0;
	}
	
	@Override
	public int size_() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		if (this.head == null) {
			return true;
		}
		return false;
	}
	
	@Override
	public int peekFirst() {
		if (isEmpty()) {
			throw new IllegalStateException("Deque vazio");
		}
		return this.head.value;
	}
	
	@Override
	public int peekLast() {
		if (isEmpty()) {
			throw new IllegalStateException("Deque vazio");
		}
		return this.tail.value;
	}
	
	@Override
	public void addLast(int value) {
		Node newNode = new Node();
		newNode.value = value;
		if (this.head == null) {
			this.head = newNode;

		}
		else {
			newNode.previous = this.tail;
			this.tail.next = newNode;
		}
		this.tail = newNode;
		size++;
	}
	
	@Override
	public void addFirst(int value) {
		Node newNode = new Node();
		newNode.value = value;
		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		}
		else {
			this.head.previous = newNode;
			newNode.next = this.head;
			this.head = newNode;
		}
		size++;
	}
	
	@Override
	public int removeLast() {
		if (isEmpty()) {
			throw new IllegalStateException("Deque vazio");
		}
		int toRemove = this.tail.value;
		if (this.head == this.tail) {
			this.head = null;
			this.tail = null;
		}
		else {
			this.tail = this.tail.previous;
			this.tail.next = null;
		}
		size--;
		return toRemove;
	}
	
	@Override
	public int removeFirst() {
		if (isEmpty()) {
			throw new IllegalStateException("Deque vazio");
		}
		int toRemove = this.head.value;
		if (this.head == this.tail) {
			this.head = null;
			this.tail = null;
		}
		else {
			this.head = this.head.next;
			this.head.previous = null;
		}
		size--;
		return toRemove;
	}
}
