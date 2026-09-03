package vector;

public class VectorArray implements VectorInterface{
	private int tail;
	private int[] vector;
	private int length;
	private int growthValue;
	
	public VectorArray(int length, int growth) {
		this.tail = -1;
		this.vector = new int[length];
		this.length = length;
		growthValue = growth;
		
		if (growth <= 0) {
			growthValue = 0;
		}		
	}
	
	@Override
	public boolean isEmpty() {
		if (this.tail == -1) {
			return true;
		}
		return false;
	}
	@Override
	public int size_() {
		return this.tail +1;
	}
	
	@Override 
	public void insertAt(int index, int value) {
		if (index < 0 || index > this.tail+1) {
			throw new IndexOutOfBoundsException("Indice invalido");
		}
		
		if (this.tail >= this.vector.length -1) {
			if (growthValue == 0) {
				this.length*=2;
			}
			else {
				this.length+=growthValue;
			}
			int[] newVector = new int[this.length];
			for (int i=0; i<this.vector.length;i++) {
				newVector[i] = this.vector[i];
			}
			this.vector = newVector;
		}
		for (int i=this.tail;i>= index;i--) {
			this.vector[i+1] = this.vector[i];
		}
		this.vector[index] = value;
		this.tail++;
	}
	
	
	@Override
	public void add(int value) {
		if (this.tail >= this.vector.length -1) {
			if (growthValue == 0) {
				this.length*=2;
			}
			else {
				length+=growthValue;
			}
			int[] newVector = new int[this.length];
			for (int i = 0; i< this.vector.length; i++) {
				newVector[i] = this.vector[i];
			}
			this.vector = newVector;
			
		}
		this.tail++;
		this.vector[this.tail] = value;
	}
	@Override
	public int getAt(int index) {
		if (index < 0 || index > this.tail) {
			throw new IndexOutOfBoundsException("Indice invalido");
		}
		
		if (isEmpty()) {
			throw new IllegalStateException("Vetor vazio");
		}
		
		return this.vector[index];
		
	}
	@Override
	public int setAt(int index, int value) {
		if (index < 0 || index > this.tail) {
			throw new IndexOutOfBoundsException("Indice invalido");
		}
		
		if (isEmpty()) {
			throw new IllegalStateException("Vetor vazio");
		}
		int toRemove = this.vector[index];
		this.vector[index] = value;
		return toRemove;
	}
	@Override
	public int removeAt(int index) {
		if (index < 0 || index > this.tail) {
			throw new IndexOutOfBoundsException("Indice invalido");
		}
		
		if (isEmpty()) {
			throw new IllegalStateException("Vetor vazio");
		}
		int toRemove = this.vector[index];
		for (int i = index; i<this.tail;i++) {
			this.vector[i] = this.vector[i+1];
		}
		this.tail--;
		return toRemove;
	}
}
