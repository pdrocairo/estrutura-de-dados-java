package list;

public class DoubleLinkedList {
	public class Node{
		int value;
		Node previous = null;
		Node next = null;
	}

	private int size;
	
	private Node firstSentinel;
	private Node lastSentinel;
	
	public DoubleLinkedList() {
		this.size = 0;
		firstSentinel = new Node();
		lastSentinel = new Node();
		firstSentinel.next = lastSentinel;
		lastSentinel.previous = firstSentinel;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		if (firstSentinel.next == lastSentinel) {
			return true;
		}
		return false;
	}
	
	public boolean isFirst(Node node) {
		if (node == firstSentinel.next) {
			return true;
		}
		return false;
	}
	
	public boolean isLast(Node node) {
		if (node == lastSentinel.previous) {
			return true;
		}
		return false;
	}
	
	public int first() {
		if (isEmpty()) {
			throw new IllegalStateException("Lista vazia");
		}
		return firstSentinel.next.value;
	}
	
	public int last() {
		if (isEmpty()) {
			throw new IllegalStateException("Lista vazia");
		}
		return lastSentinel.previous.value;
	}
	
	public int before (Node node) {
		if (isEmpty()) {
			throw new IllegalStateException("Lista vazia");
		}
		if (node == firstSentinel) {
			throw new IllegalArgumentException("Nao existe nenhum no anterior");
		}
		return node.previous.value;
	}
	
	public int after(Node node) {
		if (isEmpty()) {
			throw new IllegalStateException("Lista vazia");
		}
		if (node == lastSentinel) {
			throw new IllegalArgumentException("Nao existe nenhum no a frente");
		}
		return node.next.value;
	}
	
	public int replaceElement(Node node, int value) {
		if (isEmpty()) {
			throw new IllegalStateException("Lista vazia");
		}
		int toRemove = node.value;
		node.value = value;
		return toRemove;
	}
	
	public void swapElement(Node a, Node b) {
		if (isEmpty()) {
			throw new IllegalStateException("Lista vazia");
		}
		int valueA = a.value;
		a.value = b.value;
		b.value = valueA;
	}
	
	public int insertBefore(Node node, int value) {
		Node newNode = new Node();
		newNode.value = value;
		
		node.previous.next = newNode;
		newNode.previous = node.previous;
		newNode.next = node;
		node.previous = newNode;
		
		this.size++;
		return newNode.value;
	}
	
	public int insertAfter(Node node, int value) {
		Node newNode = new Node();
		newNode.value = value;
		
		newNode.previous = node;
		newNode.next = node.next;
		node.next = newNode;
		newNode.next.previous = newNode;
		
		this.size++;
		return newNode.value;
	}
	
	public int insertFirst(int value) {
		return insertAfter(firstSentinel, value);
	}
	
	public int insertLast(int value) {
		return insertBefore(lastSentinel, value);
	}
	
	public int remove(Node node) {
		if (isEmpty()) {
			throw new IllegalStateException("Lista vazia");
		}
		
		if (node == firstSentinel || node == lastSentinel) {
			throw new IllegalArgumentException("Impossivel remover no sentinela");
		}
		int toRemove = node.value;
		node.previous.next = node.next;
		node.next.previous = node.previous;
		node.previous = null;
		node.next = null;
		
		this.size--;
		return toRemove;
		
	}
	
	public int element(Node node) {
		return node.value;
	}
	

}
