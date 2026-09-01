package queues;

public class CircularQueue implements QueueInterface{

	private int[] queue;
	private int head;
	private int tail;
	private int size;
	private int length;
	
	public CircularQueue(int length) {
		queue = new int[length];
		this.size = 0;
		this.length = length;
		this.head = 0;
		this.tail = 0;
		
	}
	
	public boolean isEmpty() {
		if (this.head == -1) {
			return true;
		}
		return false;
	}
	
	public boolean isFull() {
		if(this.tail == this.length) {
			return true;
		}
		return false;
	}
	
	public void enqueue(int value) {
		if (isFull()) {
			throw new IllegalStateException("Fila cheia");
		}
		queue[this.tail] = value;
		this.tail = (this.tail + 1)% this.length;
		this.size++;
		
	}
	
	public int dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException("Fila vazia");
		}
		int toRemove = queue[this.head];
		this.head = (this.head + 1) % this.length;
		this.size--;
		return toRemove;
	}
	
	public int size_() {
		return this.size;
	}
	
	public int back() {
		return this.tail;
	}
	
	public int front() {
		return this.head;
	}
}
