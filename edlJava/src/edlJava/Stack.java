package edlJava;

public class Stack {
    private int last;
    private int[] stack;

    public Stack(int lenght) {
        last = -1;
        stack = new int[lenght];
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