package list;

public class ListArray {
	private int[] list;
	private int size;
	private int growthValue;
    private int length;
    
    public ListArray(int length, int growth) {
    	list = new int[length];
    	this.size = 0;
    	this.length = length;
    	growthValue = growth;
    	if (growth <= 0) {
    		growthValue = 0;
    	}
    }
    
    public int size_() {
    	return this.size;
    }
    
    public boolean isEmpty() {
    	if (this.size == 0) {
    		return true;
    	}
    	return false;
    }
    
    public int first() {
    	if (isEmpty()) {
    		throw new IllegalStateException("Lista vazia");
    	}
    	return list[0];
    }
    
    public int last() {
    	if (isEmpty()) {
    		throw new IllegalStateException("Lista vazia");
    	}
    	return list[this.size -1];
    }
    
    public boolean isFirst(int value) {
    	if (isEmpty()) {
    		throw new IllegalStateException("Lista vazia");
    	}
    	if (first() == value) {
    		return true;
    	}
    	return false;
    }
    
    public boolean isLast(int value) {
    	if (isEmpty()) {
    		throw new IllegalStateException("Lista vazia");
    	}
    	if (last() == value) {
    		return true;
    	}
    	return false;
    }
    
    public int before(int index) {
    	if (isEmpty()) {
    		throw new IllegalStateException("Lista vazia");
    	}
    	if (index < 0 || index >= this.size) {
    		throw new IndexOutOfBoundsException("Indice invalido");
    	}
    	
    	if (index == 0) {
    		throw new IllegalStateException("Nao existe valor anterior a este indice digitado");
    	}
    	
    	return list[index -1];
    }
    
    public int after(int index) {
    	if (isEmpty()) {
    		throw new IllegalStateException("Lista vazia");
    	}
    	
    	if (index < 0 || index >= this.size) {
    		throw new IndexOutOfBoundsException("Indice invalido");
    	}
    	
    	if (this.size -1 == 1) {
    		throw new IndexOutOfBoundsException("Nao existe valor apos este indice digitado");
    	}
    	
    	return list[index +1]; 	
    }
    
    public int elemAtRank(int index) {
    	if (isEmpty()) {
    		throw new IllegalStateException("Lista vazia");
    	}
    	
    	if (index < 0 || index >= this.size) {
    		throw new IndexOutOfBoundsException("Indice invalido");
    	}
    	
    	return list[index];
    }
    
    public int replaceElement(int index, int value) {
    	if (isEmpty()) {
    		throw new IllegalStateException("Lista vazia");
    	}
    	
    	if (index < 0 || index >= this.size) {
    		throw new IndexOutOfBoundsException("Indice invalido");
    	}
    	
    	int toRemove = list[index];
    	list[index] = value;
    	return toRemove;
    }
    
    public boolean resizeArray() {
    	if (this.size == this.length) {
            if (growthValue == 0) {
                this.length *= 2;
            } else {
                this.length += growthValue;
            }
            int[] newList = new int[this.length];
            
            for (int i = 0; i < this.size; i++) {
                newList[i] = list[i];
            }
            list = newList;
            return true;
        }
    	return false;
    }
    public void swapElement(int indexA, int indexB) {
    	if (isEmpty()) {
    		throw new IllegalStateException("Lista vazia");
    	}
    	
    	if (indexA < 0 || indexA >= this.size) {
    		throw new IndexOutOfBoundsException("Indice invalido");
    	}
    	
    	if (indexB < 0 || indexB >= this.size) {
    		throw new IndexOutOfBoundsException("Indice invalido");
    	}
    	
    	if (this.size == 1) {
    		throw new IllegalStateException("A lista so possui um unico item");
    	}
    	
    	if (indexA == indexB) {
    		throw new IllegalStateException("Indices iguais");
    	}
    	
    	int temp = list[indexA];
    	list[indexA] = list[indexB];
    	list[indexB] = temp;
    }
    
    public void insertFirst(int value) {
    	resizeArray();
    	
    	for (int i = this.size; i > 0; i--) {
            list[i] = list[i - 1];
        }
    	
    	list[0] = value;
        this.size++;
    	
    }
    
    public void insertLast(int value) {
    	resizeArray();
    	
    	list[this.size] = value;
    	this.size++;
    }
    
    public void insertBefore(int index, int value) {
    	if (index < 0 || index >= this.size) {
    		throw new IndexOutOfBoundsException("Indice invalido");
    	}
    	resizeArray();
    	
    	for (int i = this.size; i>index;i--) {
    		list[i] = list[i-1];
    	}
    	list[index] = value;
    	this.size++;
    }
    
    public void insertAfter(int index, int value) {
    	if (index < 0 || index >= this.size) {
    		throw new IndexOutOfBoundsException("Indice invalido");
    	}
    	resizeArray();
    	
    	for (int i = this.size; i>index+1;i--) {
    		list[i] = list[i-1];
    	}
    	list[index+1] = value;
    	this.size++;
    }
    
    public int remove(int index) {
    	if (isEmpty()) {
    		throw new IllegalStateException("Lista vazia");
    	}
    	
    	if (index < 0 || index >= this.size) {
    		throw new IndexOutOfBoundsException("Indice invalido");
    	}
    	int toRemove = list[index];
    	for (int i = index; i<this.size-1;i++) {
    		list[i] = list[i+1];
    	}
    	this.size--;
    	return toRemove;
    }
    
    
    
    
    
    
    
    
    
}
