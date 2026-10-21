package trees;

public class TestGenericTree {
	public static void main(String[] args){
		GenericTree t = new GenericTree();
		Node a = t.addRoot(1);
		Node b = t.addChild(a, 2);
		t.addChild(a, 3);
		t.addChild(b, 4);
		System.out.println(t.height());    // 2
		System.out.println(t.elements());  // [1, 2, 4, 3]
	}
}
