package sequence;

// implements SequenceInterface<T>
public class SequenceDoubleLinkedList<T> implements SequenceInterface<T>{
	public class Node implements Position<T>{
		T value;
		Node previous;
		Node next;
		
		@Override
		public T value() {
			return this.value();
		}
	}
	
	private Node firstSentinel;
	private Node lastSentinel;
	private int size_;
	
	public SequenceDoubleLinkedList() {
		this.firstSentinel = new Node();
		this.lastSentinel = new Node();
		this.size_ = 0;
		this.firstSentinel.next = this.lastSentinel;
		this.lastSentinel.previous = this.firstSentinel;
	}
	@Override
	public boolean isEmpty() {
		if (this.size_ == 0) {
			return true;
		}return false;
	}
	@Override
	public int size() {
		if (isEmpty()) {
			throw new IllegalStateException("sequencia vazia");
		}
		return this.size_;
	}
	@Override
	public Position<T> first(){
		if (isEmpty()) {
			throw new IllegalStateException("sequencia vazia");
		}
		return this.firstSentinel.next;
	}
	@Override
	public Position<T> last(){
		if (isEmpty()) {
			throw new IllegalStateException("sequencia vazia");
		}
		return this.lastSentinel.previous;
	}
	@Override
	public boolean isFirst(Position<T> position) {
		if (isEmpty()) {
			throw new IllegalStateException("sequencia vazia");
		}
		if (this.firstSentinel.next == position) {
			return true;
		}
		return false;
	}
	@Override
	public boolean isLast(Position<T> position) {
		if (isEmpty()) {
			throw new IllegalStateException("sequencia vazia");
		}
		if (this.lastSentinel.previous == position) {
			return true;
		}
		return false;
	}
	@Override
	public Position<T> insertFirst(T value){
		Node newNode = new Node();
		newNode.value = value;
		
		newNode.previous = this.firstSentinel;
		this.firstSentinel.next.previous = newNode;
		newNode.next = this.firstSentinel.next;
		this.firstSentinel.next = newNode;
		
		this.size_++;
		return newNode;
	}
	@Override
	public Position<T> insertLast(T value){
		Node newNode = new Node();
		newNode.value = value;
		
		newNode.next = this.lastSentinel;
		this.lastSentinel.previous.next = newNode;
		newNode.previous = this.lastSentinel.previous;
		this.lastSentinel.previous = newNode;
		
		this.size_++;
		return newNode;
	}
	@Override
	private Node checkPosition(Position<T> position) {
		if (position == null) {
			throw new IllegalArgumentException("position nao pode ser null");
		}
		if (position instanceof SequenceDoubleLinkedList.Node == false) {
			throw new IllegalArgumentException("position nao eh valida para essa lista");
		}
		
		Node node = (Node) position;  // conversao de Position para node, agora expoe os ponteiros alem do value
		
		if (node == this.firstSentinel || node == this.lastSentinel) {
			throw new IllegalArgumentException("Eh um node sentinel");
		}
		
		return node;
	}
	@Override
	public Position<T> before(Position<T> position){
		if (isEmpty()) {
			throw new IllegalStateException("sequencia vazia");
		}
		if (checkPosition(position).previous == this.firstSentinel) {
			throw new IllegalStateException("nao existe elemento anterior ao primeiro");
		}
		return checkPosition(position).previous;
	}
	@Override
	public Position<T> after(Position<T> position){
		if (isEmpty()) {
			throw new IllegalStateException("sequencia vazia");
		}
		if (checkPosition(position).next == this.lastSentinel) {
			throw new IllegalStateException("nao existe elemento depois do ultimo");
		}
		
		return checkPosition(position).next;
	}
	@Override
	public T replaceValue(Position<T> position, T value) {
		if (isEmpty()) {
			throw new IllegalStateException("sequencia vazia");
		}
		T toRemove = checkPosition(position).value;
		checkPosition(position).value = value;
		
		return toRemove;
	}
	@Override
	public void swapValues(Position<T> positionA, Position<T> positionB) {
		if (isEmpty()) {
			throw new IllegalStateException("sequencia vazia");
		}
		
		Node nodeA = checkPosition(positionA);
		Node nodeB = checkPosition(positionB);
		T valueA = nodeA.value;
		nodeA.value = nodeB.value;
		nodeB.value = valueA;
	}
	@Override
	public Position<T> insertBefore(Position<T> position, T value){
		if (isEmpty()) {
			throw new IllegalStateException("sequencia vazia");
		}
		Node newNode = new Node();
		newNode.value = value;
		
		Node current = checkPosition(position);
		
		current.previous.next = newNode;
		newNode.previous = current.previous;
		newNode.next = current;
		current.previous = newNode;
		this.size_++;
		
		return newNode;
	}
	@Override
	public Position<T> insertAfter(Position<T> position, T value){
		if (isEmpty()) {
			throw new IllegalStateException("sequencia vazia");
		}
		
		Node newNode = new Node();
		newNode.value = value;
		
		Node current = checkPosition(position);
		current.next.previous = newNode;
		newNode.next = current.next;
		newNode.previous = current;
		current.next = newNode;
		this.size_++;
		return newNode;
	}
	@Override
	public T remove(Position<T> position) {
		if (isEmpty()) {
			throw new IllegalStateException("sequencia vazia");
		}
		Node node = checkPosition(position);
		T toRemove = node.value;
		
		node.previous.next = node.next;
		node.next.previous = node.previous;
		node.previous = null;
		node.next = null;
		this.size_--;
		return toRemove;
	}
	
	
	
}