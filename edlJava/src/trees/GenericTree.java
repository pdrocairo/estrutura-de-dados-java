package trees;

import java.util.ArrayList;
import java.util.List;

public class GenericTree{
	public class Node{
		int value;
		Node parent = null;
		List<Node> children = new ArrayList<>();

		
		public int value(){
			return this.value;
		}
		
	}
	
	private Node root;
	private int size_;
	
	public GenericTree(){
		this.root = null;
		this.size_ = 0;
	}
	
	public int size(){
		return this.size_;
	}
	
	public boolean isEmpty(){
		if (this.root == null){
			return true;
		}return false;
	}
	
	public Node root(){
		return this.root;
	}
	
	public Node parent(Node node){
		return node.parent;
	}
	
	public List<Node> children(Node node){
		return node.children;
	}
	
	public int replace(Node node, int value){
		int toRemove = node.value;
		node.value = value;
		return toRemove;
	}
	
	public Node addRoot(int value){
		Node newNode = new Node();
		newNode.value = value;
		this.root = newNode;
		this.size_++;
		return newNode;
	}
	
	public Node addChild(Node parent, int value){
		Node newNode = new Node();
		newNode.value = value;
		newNode.parent = parent;
		parent.children.add(newNode);
		this.size_++;
		return newNode;
	}
	
	public boolean isExternal(Node node) {
		if (node.children.size() == 0){
			return true;
		}return false;
	}
	
	public boolean isInternal(Node node){
		if (node.children.size() != 0){
			return true;
		}return false;
	}
	
	public boolean isRoot(Node node){
		if (node == root()){
			return true;
		}return false;
	}
	
	public List<Integer> elements(){
		List<Integer> list = new ArrayList<>();
		for (Node node: nodes()){
			list.add(node.value);
		}
		return list;
	}
	
	public int depth(Node node){
		if (isRoot(node)){
			return 0;
		}
		return 1 + depth(node.parent);
	}
	
	private void preOrder(Node node, List<Node> list){
		list.add(node);
		for (Node child : node.children){
			preOrder(child, list);
		}
	}
	
	private void postOrder(Node node, List<Node> list){
		for (Node child : node.children){
			postOrder(child, list);
		}
		list.add(node);
	}
	
	public List<Node> nodes(){
		List<Node> list = new ArrayList<>();
		preOrder(this.root, list);
		return list;
	}
	
	private int height(Node node){
		if (isExternal(node)){
			return 0;
		}
		
		int h = 0;
		
		for (Node child : node.children){
			int childHeight = height(child);
			if (childHeight> h){
				h = childHeight;
			}
		}
		return 1 +h;
	}
	
	public int height(){
		return height(this.root);
	}
}
