package sequence;

public class Sequence<T> implements SequenceInterface<T>{
	public class Slot<T> implements Position<T>{
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
		sequence = new Slot[length];
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
			Slot[] newSequence = new Slot[this.length];
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
}
