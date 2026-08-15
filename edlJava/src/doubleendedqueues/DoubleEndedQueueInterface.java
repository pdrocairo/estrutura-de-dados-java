package doubleendedqueues;

public interface DoubleEndedQueueInterface {
	void addFirst(int value);
	void addLast(int value);
	int removeFirst();
	int removeLast();
	int peekFirst();
	int peekLast();
	boolean isEmpty();
	int size_();
}
