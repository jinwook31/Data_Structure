package AVLTree;

public class Test {
	public static void main(String [] args){
		
		System.out.println("1.add");
		AVLTree tree = new AVLTree();
		tree.add(3);
		tree.add(5);
		tree.add(1);
		tree.add(1);
		tree.add(8);
		tree.add(6);
		tree.add(2);
		tree.add(11);
		tree.add(4);
		tree.add(10);
		tree.add(9);
		tree.add(7);
		tree.inorder();
		
		System.out.println("\n");
		/*
		System.out.println("2. delete");
		tree.delete(3);
		tree.delete(5);
		tree.delete(1);
		tree.delete(8);
		tree.delete(6);
		tree.toString();
	*/
	}
}
