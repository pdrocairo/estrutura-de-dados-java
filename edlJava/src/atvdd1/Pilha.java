//1. A class deve conter duas pilhas, red e black e suas devidas ops.
//2. O pushRed deve iniciar da esquerda pra direita.
//3. O pushBlack deve iniciar da direita pra esquerda.
//4. Array deve ser compartilhado entre as pilhas.
//5. A capacidade do array eh limitada por N.
//6. N sempre eh maior que a soma dos length das duas pilhas.
//7. Se array estiver cheio, dobra a capacidade
//8. Se array utilizou capacidade/3, divide por 2. 

package atvdd1;

public class Pilha {
	private int[] array;
	private int topRed;
	private int topBlack;
	private int growth;
	private int sizeB;
	private int sizeR;
	
	public Pilha(int capacity) {
		this.topRed = -1;
		this.topBlack = capacity;
		this.array = new int[capacity];
		this.growth = capacity; 
		this.sizeB = 0;
		this.sizeR = 0;
		
		if (capacity <= 0) {
			this.growth = 0;
		}
		
		
		
	}
	
	private void tryResize() {
		int n = sizeR + sizeB;
		int oldGrowth = this.growth;
	
		if (this.topBlack -1 == this.topRed) {
    		this.growth*=2;
    		int[] newArray = new int[this.growth];
    		for (int r=0; r< this.sizeR;r++) {
    			newArray[r] = array[r];
    		}
    		for (int b=oldGrowth-1; b> this.topBlack -1;b--) {
    			newArray[b+this.growth-oldGrowth] = array[b];
    		}
    		this.topBlack = this.topBlack + this.growth-oldGrowth;
    		array = newArray;
    	}
		else if(n*3 == this.growth) {
    		this.growth/=2;
    		int[] newArray = new int[this.growth];
    		for (int r=0; r< this.sizeR;r++) {
    			newArray[r] = array[r];
    		}
    		for (int b=oldGrowth-1; b> this.topBlack -1;b--) {
    			newArray[b+this.growth-oldGrowth] = array[b];
    		}
    		this.topBlack = this.topBlack + this.growth-oldGrowth;
    		array = newArray;
    	}
	}
	
	public boolean isEmptyR() {
		if (this.sizeR == 0) {
			return true;
		}
		return false;
	}
	
	public boolean isEmptyB() {
		if (this.sizeB == 0) {
			return true;
		}
		return false;
	}
	
	public int topR() {
        return array[this.topRed];
    }

	public int topB() {
        return array[this.topBlack];
    }
	
    public int sizeR_() {
        return this.sizeR;
    }
    
    public int sizeB_() {
        return this.sizeB;
    }
    
    public void pushR(int value) {
    	this.topRed++;
    	tryResize();
    	array[this.topRed] = value;
    	this.sizeR++;
    	
    }
    
    public void pushB(int value) {
    	this.topBlack--;
    	tryResize();
    	array[this.topBlack] = value;
    	this.sizeB++;

    }
    
    public int popR() {
    	if (isEmptyR()) {
    		throw new IllegalStateException("Array Vermelho vazio");
    	}
    	int toRemove = array[this.topRed];
    	this.topRed--;
    	this.sizeR--;
    	tryResize();
    	return toRemove;
    	
    }
    
    public int popB() {
    	if (isEmptyB()) {
    		throw new IllegalStateException("Array Preto vazio");
    	}
    	int toRemove = array[this.topBlack];
    	this.topBlack++;
    	this.sizeB--;
    	tryResize();
    	return toRemove;
    }
    
    public void displayR() {
    	if (isEmptyR()) {
    		throw new IllegalStateException("Array Vermelho Vazio");
    	}
    	for (int i=0; i<this.sizeR;i++) {
    		System.out.println(array[i]+" ");
    	}
    }
    
    public void displayB() {
    	if (isEmptyB()) {
    		throw new IllegalStateException("Array Preto Vazio");
    	}
    	for (int i=this.growth-1; i>this.topBlack -1;i--) {
    		System.out.println(array[i]+" ");
    	}
    	System.out.println();
    }
    

}
