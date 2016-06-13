package DS_Performance_AVL_BST_HT_LL;

public class AVLTree {   //Height balanced tree
	private String key;
	private int height;
	private AVLTree left,right;
	private int num = 1;

	public static final AVLTree NIL = new AVLTree();
	
	public AVLTree(String key){
		this.key=key;
		left=right=NIL;
	}
	
	public boolean add(String key) {
		int oldSize = size();
		grow(key);
		return size() > oldSize;
	}
	
	public AVLTree grow(String key){
		if(this == NIL) return new AVLTree(key);
		if(key.compareTo(this.key) == 0){ this.num++; return this; }
		if(key.compareTo(this.key) < 0) left = left.grow(key);
		else right = right.grow(key);
		rebalance();
		height = 1+Math.max(left.height, right.height);
		return this;
	}
	
	public int size(){
		if(this == NIL) return 0;
		return 1+left.size() + right.size();
	}
	
	public String toString(){ 
		if(left != NIL) left.toString();
		System.out.println(key + " : " +num);
		if(right != NIL) right.toString();
		return null;
	}
	
	private AVLTree(){
		left = right = this;
		height = -1;
	}
	
	private AVLTree(String key, AVLTree left, AVLTree right){
		this.key = key;
		this.left = left;
		this.right = right;
		height = 1+ Math.max(left.height, right.height);
	}
	
	private void rebalance(){
		if(right.height > left.height +1){
			if(right.left.height > right.right.height) right.rotateRight();
			rotateLeft();
		}
		else if(left.height > right.height+1){
			if(left.right.height > left.left.height) left.rotateLeft();
			rotateRight();
		}
	}
	
	private void rotateRight(){
		right = new AVLTree(key,left.right,right);
		key=left.key;
		left=left.left;
	}
	
	private void rotateLeft(){
		left = new AVLTree(key,left,right.left);
		key=right.key;
		right=right.right;
	}
}