package edlJava;

public class StackRevisado {
    private int last;
    private int[] stack;
    private int tipoCrescimento;
    private int lenght;
    
    public StackRevisado(int lenght, int crescimento) {
    	this.lenght = lenght;
        last = -1;
        stack = new int[lenght];
        tipoCrescimento = crescimento;
        if (crescimento <= 0) {
        	tipoCrescimento = 0;
        }
    }

    public boolean isEmpty() {
        if (last == -1) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (last == stack.length -1) {
            return true;
        }
        return false;
    }

    public void push(int value) {
        if (isFull()) {
            throw new IllegalStateException("A pilha ja atingiu sua capacidade maxima");
        }
        last++;
        stack[last] = value;
    }
    
    public void push2(int value) {
    	if (last >= lenght-1) {
    		if (tipoCrescimento == 0) {
    			lenght*=2;
    		}
    		else {
    			lenght+=tipoCrescimento;
    		}
    		int[] newStack = new int[lenght];
    		
    		for (int i=0; i<stack.length; i++) {
    			newStack[i] = stack[i];
    		}
    		stack = newStack;
    	}
    	stack[++last] = value;
    	    		
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha ja esta vazia");
        }
        int toRemove = stack[last]; 
        last--;
        return toRemove;
    }

    public int top() {
        return stack[last];
    }

    public int size() {
        return last + 1;
    }

    public boolean contains(int value) {
        for (int i = 0; i < stack.length; i++) {
            if (value == stack[i]) {
                return true;
            }
        }
        return false;
    }
}