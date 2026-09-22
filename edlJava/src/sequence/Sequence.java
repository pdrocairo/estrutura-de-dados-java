package sequence;

public class Sequence<T> implements SequenceInterface<T>{
	public class Slot implements Position<T>{
		T value;
		int index;
		
		@Override
		public T value() {
			return this.value;
		}
	}
	private Slot[] sequence;
	private int length;
	private int growthValue;
	private int size_;
	
	public Sequence(int length, int growth) {
		sequence = (Slot[])new Object[length];
		this.size_ = 0;
		this.length = length;
		growthValue = growth;
		if (growth <= 0) {
			growthValue = 0;
		}
	}
	
	public void tryResize() {
		if (this.size_ == this.length) {
			if (growthValue == 0) {
				this.length*=2;
			}else {
				this.length+=growthValue;
			}
			Slot[] newSequence = (Slot[]) new Object[this.length];
			for (int i=0;i<this.size_;i++) {
				newSequence[i] = sequence[i];
			}
			sequence = newSequence;
		}
	}
	
	public Slot checkPosition(Position<T> position) {
		if (position == null) {
			throw new IllegalArgumentException("position nao pode ser null");
		}
		
		if (position instanceof Sequence.Slot == false) {
			throw new IllegalArgumentException("position nao eh valida para essa sequencia");
		}
		return (Slot)position;
	}
	
	public boolean isEmpty() {
		if (this.size_ == 0) {
			return true;
		}return false;
	}
	
	public int size() {
		if (isEmpty()) {
			throw new IllegalStateException("sequencia esta vazia");
		}
		return this.size_;
	}
	
	public Position<T> first(){
		if (isEmpty()) {
			throw new IllegalStateException("sequencia esta vazia");
		}
		return sequence[0];
	}
	
	public Position<T> last(){
		if (isEmpty()) {
			throw new IllegalStateException("sequencia esta vazia");
		}
		return sequence[this.size_-1];
	}
	
	public boolean isFirst(Position<T> position) {
		if (isEmpty()) {
			throw new IllegalStateException("sequencia esta vazia");
		}
		Slot slot= checkPosition(position);
		if (slot.index == 0) {
			return true;
		}return false;
	}
	
	public boolean isLast(Position<T> position) {
		if (isEmpty()) {
			throw new IllegalStateException("sequencia esta vazia");
		}
		Slot slot= checkPosition(position);
		if (slot.index == this.size_-1) {
			return true;
		}return false;
	}
	
	public Position<T> before(Position<T> position){
		if (isEmpty()) {
			throw new IllegalStateException("sequencia esta vazia");
		}
		if (isFirst(position)) {
			throw new IllegalStateException("nao existe posicao anterior a informada");
		}
		Slot slot = checkPosition(position);
		return sequence[slot.index-1];
		
		
	}
	
    public Position<T> after(Position<T> position){
    	if (isEmpty()) {
			throw new IllegalStateException("sequencia esta vazia");
		}
    	if (isLast(position)) {
			throw new IllegalStateException("nao existe posicao apos a que foi informada");
		}
    	Slot slot = checkPosition(position);
    	return sequence[slot.index+1];
    }
    
    public int rankOf(Position<T> position) {
    	if (isEmpty()) {
			throw new IllegalStateException("sequencia esta vazia");
		}
    	Slot slot = checkPosition(position);
    	return slot.index;
    }
    
    public Position<T> atRank(int idx){
    	if (idx < 0 || idx > this.size_) {
    		throw new IllegalStateException("fora do range");
    	}
    	if (isEmpty()) {
			throw new IllegalStateException("sequencia esta vazia");
		}
    	return sequence[idx];
    }
    
    public T replaceAtRank(int idx, T value) {
    	if (idx < 0 || idx > this.size_) {
    		throw new IllegalStateException("fora do range");
    	}
    	if (isEmpty()) {
			throw new IllegalStateException("sequencia esta vazia");
		}
    	Slot slot = sequence[idx];
    	T toRemove = slot.value;
    	slot.value = value;
    	
    	return toRemove;
    }
}
