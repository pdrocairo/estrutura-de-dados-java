package queues;

public interface QueueInterface {
	boolean isEmpty();
	int size_();
	int front();
	int back();
	void enqueue(int value);
	int dequeue();
}
