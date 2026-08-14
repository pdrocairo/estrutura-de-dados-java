package queues;

public class Queue implements QueueInterface{
	private int head;
	private int tail;
	private int[] queue;
	private int length;
	private int growthValue;
	private int size;
	
	
	
	public Queue(int length, int growth) {
		this.length = length;
		size = 0;
		head = 0;
		tail = -1;
		queue = new int[length];
		growthValue = growth;
		if (growth <= 0) {
			growthValue = 0;
		}
	}
	
	@Override
	public void enqueue(int value) {
		if (tail>= queue.length -1) {
			if (growthValue == 0) {
				length*=2;
			}
			else {
				length+=growthValue;
			}
			int[] newQueue = new int[length];
			
			for (int i=0; i< queue.length; i++) {
				newQueue[i] = queue[i];
			}
			queue = newQueue;
		}
		size++;
		tail++;
		queue[tail] = value;
	}
	
	@Override
	public int dequeue() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Fila esta vazia");
		}
		int toRemove = queue[head];
		size--;
		if (this.head == this.tail) {
			this.head = -1;
			this.tail = -1;
		}
		else {
			head++;
		}
		
		return toRemove;
	}
	
	@Override
	public int front() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Fila esta vazia");
		}
		return queue[head];
	}
	
	@Override
	public boolean isEmpty() {
		if (tail == -1) {
			return true;
		}
		return false;
	}
	
	@Override
	public int size_() {
		return size;
	}
	
	@Override
	public int back() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Fila esta vazia");
		}
		return queue[tail];
	}
	

	public boolean isFull() {
		if (tail >=queue.length -1) {
			return true;
		}
		return false;
	}
}
