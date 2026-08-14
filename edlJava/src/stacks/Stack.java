package stacks;

public class Stack implements StackInterface{
    private int last;
    private int[] stack;
    private int growthValue;
    private int lenght;
    
    
    public Stack(int lenght, int growth) {
        last = -1;
        stack = new int[lenght];
        growthValue = growth;
        this.lenght = lenght;
        
        if (growth <= 0) {
        	growthValue = 0;
        }
    }
    
    
    @Override
    public boolean isEmpty() {
        if (last == -1) {
            return true;
        }
        return false;
    }
    

    @Override
    public void push(int value) {
        if (last >= stack.length -1) {
        	if (growthValue == 0) {
        		lenght*=2;
        	}
        	else {
        		lenght+=growthValue;
        	}
        	int[] newStack = new int[lenght];
        	for (int i=0; i < stack.length; i++) {
        		newStack[i] = stack[i];
        	}
        	stack = newStack;
        }
        last++;
        stack[last] = value;
    }
    
    @Override
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha ja esta vazia");
        }
        int toRemove = stack[last]; 
        last--;
        return toRemove;
    }
    
   
    @Override
    public int top_() {
        return stack[last];
    }
    
    
    @Override
    public int size_() {
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
    
    
    public boolean isFull() {
        if (last == stack.length -1) {
            return true;
        }
        return false;
    }
}