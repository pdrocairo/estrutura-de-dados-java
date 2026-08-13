package edlJava;

public interface StackInterface {
	boolean isEmpty();
	boolean isFull();
	void push(int value);
	int pop();
	int top();
	int size();
	boolean contains(int value);
	
}
