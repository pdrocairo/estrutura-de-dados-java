package atividade2;

public class BinarySearch {
	
	public class Node{
		int value;
		Node left, right;
		
		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
		
		public int value() {
			return this.value;
		}
	}
	
	private Node root;
	
	public BinarySearch() {
		this.root = null;
	}
	
	public void insert(int value) {
		this.root = insert(this.root, value);
	}
	
	private Node insert(Node node, int value) {
		if (node == null) {
			return new Node(value);
		}
		if (value < node.value) {
			node.left = insert(node.left, value);
		} else if (value > node.value) {
			node.right = insert(node.right, value);
		}
		return node;
	}
	
	public boolean search(int value) {
		return search(this.root, value);
	}
	
	private boolean search(Node node, int value) {
		if (node == null) {
			return false;
		}
		if (value == node.value) {
			return true;
		}
		if (value < node.value) {
			return search(node.left, value);
		}
		return search(node.right, value);
	}
	
	public void remove(int value) {
		this.root = remove(this.root, value);
	}
	
	private Node remove(Node node, int value) {
		if (node == null) {
			return null;
		}
		if (value < node.value) {
			node.left = remove(node.left, value);
		} else if (value > node.value) {
			node.right = remove(node.right, value);
		} else {
			if (node.left == null) {
				return node.right;
			}
			if (node.right == null) {
				return node.left;
			}
			Node menor = node.right;
			while (menor.left != null) {
				menor = menor.left;
			}
			node.value = menor.value;
			node.right = remove(node.right, menor.value);
		}
		return node;
	}
	
	public void show() {
		show(this.root, 0);
	}

	private void show(Node node, int espaco) {
		if (node == null) {
			return;
		}
		show(node.right, espaco + 4);
		for (int i = 0; i < espaco; i++) {
			System.out.print(" ");
		}
		System.out.println(node.value);
		show(node.left, espaco + 4);
	}
}
