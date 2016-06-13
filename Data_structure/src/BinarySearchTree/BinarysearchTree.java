package BinarySearchTree;

public class BinarysearchTree {
	BinarytreeNode head;
	private int size = 0;
	
	public void add(int x){
			head = add(x, head);
			size++;
	}
	
	private BinarytreeNode add(int x, BinarytreeNode node){
			if(node == null){
				node = new BinarytreeNode(x);
			}else if(node.element > x){
				node.leftchild = add(x, node.leftchild);
			}else if(node.element < x){
				node.rightchild = add(x, node.rightchild);
			}
		return node;
	}
	
	public boolean search(int x){
		return search(x, head);
	}
	
	private boolean search(int x, BinarytreeNode node){
		boolean found = false;
		if(node == null){
			found = false;
		}else if(node.element == x){
			System.out.println("비교 : "+ x + " " + node.element);
			found = true;
		}else if(node.element > x){
			System.out.println("비교 : "+ x + " " + node.element);
			found = search(x, node.leftchild);
		}else if(node.element < x){
			System.out.println("비교 : "+ x + " " + node.element);
			found = search(x, node.rightchild);
		}
		return found;
	}
	
	public void inorderPrint(){
		inorderPrint(head);
		System.out.println("");
	}
	
	private void inorderPrint(BinarytreeNode node){
		if(node != null){
			inorderPrint(node.leftchild);
			System.out.print(node.element + " ");
			inorderPrint(node.rightchild);
		}
	}
	
	public void delete(int x){
			head = delete(x, head);
			size--;
	}
	
	private BinarytreeNode delete(int x, BinarytreeNode node){
		if(node == null){
			return node;
		}
		if(node.element > x){
			node.rightchild = delete(x, node.rightchild);
		}else if(node.element < x){
			node.leftchild = delete(x, node.leftchild);
		}else if(node.leftchild != null && node.rightchild != null){
			node.element = findMin(node.rightchild).element;
			node.rightchild = delete(node.element, node.rightchild);
		}else{
			node = (node.leftchild != null) ? node.leftchild : node.rightchild;
		}
		return node;
	}
	
	private BinarytreeNode findMin(BinarytreeNode node){
		if(node == null){
			return null;
		}else if(node.leftchild == null){
			return node;
		}
		return findMin(node.leftchild);
	}
	
	private static class BinarytreeNode{
		int element;
		BinarytreeNode leftchild;
		BinarytreeNode rightchild;
		
		BinarytreeNode(int element){
			this.element = element;
			this.leftchild = null;
			this.rightchild = null;
		}
		
		BinarytreeNode(int element, BinarytreeNode leftchild, BinarytreeNode rightchild){
			this.element = element;
			this.leftchild = leftchild;
			this.rightchild = rightchild;
		}
	}
}
