package vector;

public class VectorDoubleLinkedList implements VectorInterface{
	public class Node{
		int value;
		Node previous = null;
		Node next = null;
	}
	int size;
	Node head;
	Node tail;
	
	public VectorDoubleLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		if (this.head == null) {
			return true;
		}
		return false;
	}
	@Override
	public int size_() {
		return this.size;
	}
	@Override
	public void add(int value) {
		Node newNode = new Node();
		newNode.value = value;
		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		}
		else {
			newNode.previous = this.tail;
			this.tail.next = newNode;
		}
		this.tail = newNode;
		this.size++;
	
	}
	@Override
	public int getAt(int index) {
		if(index < 0 || index>= this.size) {
			throw new IndexOutOfBoundsException("Indice invalido");
		}
		Node current = this.head;
		for (int i=0; i<index;i++) {
			current = current.next;
		}
		return current.value;
	}
	@Override
	public int setAt(int index, int value) {
		if(index < 0 || index>= this.size) {
			throw new IndexOutOfBoundsException("Indice invalido");
		}
		Node current = this.head;
		for (int i=0; i<index;i++) {
			current = current.next;
		}
		current.value = value;
		return current.value;
	}
	@Override
	public int removeAt(int index) {
		if (isEmpty()) {
			throw new IllegalStateException("Vetor vazio");
		}
		if(index < 0 || index>= this.size) {
			throw new IndexOutOfBoundsException("Indice invalido");
		}
		
		Node current = this.head;
		for (int i=0;i<index;i++) {
			current = current.next;
		}
		int toRemove = current.value;
		
		if(current == this.head) {
			if (current == this.tail) {
				this.head = null;
				this.tail = null;
			}
			else {
				this.head = this.head.next;
				this.head.previous = null;
			}
			this.size--;
			return toRemove;
		}
		
		if (current == this.tail) {
			this.tail = this.tail.previous;
			this.tail.next = null;
			this.size--;
			return toRemove;
		}
		current.next.previous = current.previous;
		current.previous.next = current.next;
		this.size--;
		return toRemove;
	}
	@Override
	public void insertAt(int value, int index) {
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException("Indice invalido");
		}
		Node newNode = new Node();
		newNode.value = value;
		
		Node current = this.head;
		for (int i=0;i<index;i++) {
			current = current.next;
		}
		if (this.isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		}
		else if (current == this.head) {
			newNode.next = current;
			current.previous = newNode;
			this.head = newNode;
		}
		else if (current == this.tail) {
			newNode.next = this.tail;
			this.tail.previous = newNode;
		}
		
		else if (current == null) {
			newNode.previous = this.tail;
			this.tail.next = newNode;
			this.tail = newNode;
		}
		else {
			newNode.next = current;
			newNode.previous =current.previous;
			current.previous.next = newNode;
			current.previous = newNode;
		}
		this.size++;

	}
}
