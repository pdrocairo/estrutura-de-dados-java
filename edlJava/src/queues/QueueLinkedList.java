package queues;

public class QueueLinkedList implements QueueInterface{
	private static class Node{
		int value;
		Node previous = null;
		Node next = null;
	}
	private Node head, tail;
	private int size;
	
	public QueueLinkedList() {
		this.head = null;
		this.tail = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}
	
	public int size_() {
		return size;
	}
	
	public int front() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue vazia");
		}
		return this.head.value;
	}
	
	public int back() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue vazia");
		}
		return this.tail.value;
	}
	
	public void enqueue(int value) {
		Node newNode = new Node();
		newNode.value = value;
		newNode.previous = null;
		newNode.next = null;
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
	
	public int dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue vazia");
		}
		if (this.head == this.tail) {
			int toRemove = this.head.value;
			this.tail = null;
			this.head = null;
			size--;
			return toRemove;
		}
		
		int toRemove = this.head.value;
		Node nextNode = this.head.next;
		this.head.next = null;
		this.head = nextNode;
		this.head.previous = null;
		size--;
		return toRemove;
	}
	
	

}
