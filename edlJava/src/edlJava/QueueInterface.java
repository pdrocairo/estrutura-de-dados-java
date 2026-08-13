package edlJava;

public interface QueueInterface {
	
	void enqueue(int value);
	int dequeue();
	int front();
	boolean isEmpty();
	boolean isFull();
	int size();
}
