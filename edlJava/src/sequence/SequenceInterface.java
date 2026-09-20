package sequence;

public interface SequenceInterface<T> {
    int size();
    boolean isEmpty();
    T valueAtRank(int idx);   
    T replaceAtRank(int idx, T value);   
    void insertAtRank(int idx, T value);    
    T removeAtRank(int idx);
    Position<T> first();    
    Position<T> last();    
    Position<T> before(Position<T> position);    
    Position<T> after(Position<T> position);    
    boolean isFirst(Position<T> position);    
    boolean isLast(Position<T> position);    
    T replaceValue(Position<T> position, T value);    
    void swapValues(Position<T> positionA, Position<T> positionB);    
    Position<T> insertBefore(Position<T> position, T value);    
    Position<T> insertAfter(Position<T> position, T value);    
    Position<T> insertFirst(T value);    
    Position<T> insertLast(T value);    
    T remove(Position<T> position);
    Position<T> atRank(int idx);    
    int rankOf(Position<T> position);
}