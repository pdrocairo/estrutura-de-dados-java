package queues;

public class QueueLinkedList implements QueueInterface{
	
	public class Node{
		int value;
		Node previous = null;
	}
	Node first = null;
	Node last = null;
	private int size;
	
	public QueueLinkedList() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		if (this.first == null) {
			return true;
		}
		return false;
	}
	
	@Override
	public int size_() {
		return this.size;
	}
	
	@Override
	public int back() {
		return this.last.value;
	}
	
	@Override
	public int front() {
		return this.first.value;
	}
	
	@Override
	public void enqueue(int value) {
		Node newNode = new Node();
		newNode.value = value;
		if (this.first == null) {
			this.first = newNode;
			this.last = newNode;
		}
		this.first.previous = newNode;
		this.first = newNode;
		size++;
	}
	
	@Override
	public int dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException("Fila vazia");
		}
		if (this.first == this.last) {
			int toRemove = this.last.value;
			this.first = null;
			this.last = null;
			size--;
			return toRemove;
		}
		int toRemove = this.last.value;
		this.last = this.last.previous;
		this.last.previous = null;
		size--;
		return toRemove;
		
	}
}
