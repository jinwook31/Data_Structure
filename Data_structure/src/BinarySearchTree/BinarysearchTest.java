package BinarySearchTree;

public class BinarysearchTest {
	public static void main(String [] args){
		BinarysearchTree BST = new BinarysearchTree();
		
		System.out.println("(1)\n중위 순회 트리 : ");
		BST.add(6);
		BST.add(4);
		BST.add(8);
		BST.add(2);
		BST.add(10);
		BST.inorderPrint();
		System.out.println();
		
		System.out.println("(2)\nsearch(9)");
		boolean s9 = BST.search(9);
		System.out.println(s9 + "\n");
		
		System.out.println("search(10)");
		boolean s10 = BST.search(10);
		System.out.println(s10 + "\n");
		
		System.out.println("(3)\n추가점수 부분(delete 메소드 구현)");
		BST.delete(6);
		System.out.print("중위 순회 트리 : ");
		BST.inorderPrint();
	}
}
