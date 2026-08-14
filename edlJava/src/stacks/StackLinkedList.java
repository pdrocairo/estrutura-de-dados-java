package stacks;

public class StackLinkedList implements StackInterface{
    private static class Node{
        int value;
        Node below;
    }
    private Node top;
    private int size;

    public StackLinkedList() {
        this.top = null;
        size = 0;
    }
    
    @Override
    public boolean isEmpty() {
        if (this.top == null && size == 0) {
            return true;
        }
        return false;
    }
    @Override
    public void push(int value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.below = this.top;
        this.top = newNode;
        size++;
    }
    @Override
    public int size_() {
    	return size;
    }
    @Override
    public int pop() {
    	if (isEmpty()) {
    		throw new IllegalStateException("Pilha vazia");
    	}
    	int toRemove = this.top.value;
    	this.top = this.top.below;
    	size--;
    	return toRemove;
    }
    
    @Override
    public int top_() {
    	if (isEmpty()) {
    		throw new IllegalStateException("Pilha vazia");
    	}
    	return this.top.value;
    }
}
    

