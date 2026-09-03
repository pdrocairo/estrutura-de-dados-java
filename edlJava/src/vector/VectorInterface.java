package vector;

public interface VectorInterface {
	boolean isEmpty();
	int size_();
	void add(int value);
	int getAt(int index);
	int setAt(int index, int value);
	int removeAt(int index);
	void insertAt(int value, int index);
}
