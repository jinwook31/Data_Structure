package DS_Performance_AVL_BST_HT_LL;

public class BinarySearchTree {
	BinarytreeNode head;
	private int size = 0;
	
	public void add(String key){
		if(search(key)){
			
		}else{
			head = add(key, head);
			size++;
		}
	}
	
	private BinarytreeNode add(String key, BinarytreeNode node){
			if(node == null){
				node = new BinarytreeNode(key);
			}else if((node.element).compareTo(key) > 0){
				node.leftchild = add(key, node.leftchild);
			}else if((node.element).compareTo(key) < 0){
				node.rightchild = add(key, node.rightchild);
			}
		return node;
	}
	
	public boolean search(String key){
		return search(key, head);
	}
	
	private boolean search(String key, BinarytreeNode node){
		boolean found = false;
		if(node == null){
			found = false;
		}else if((node.element).compareTo(key) == 0){
			found = true;
			node.count++;
		}else if((node.element).compareTo(key) > 0){
			found = search(key, node.leftchild);
		}else if((node.element).compareTo(key) < 0){
			found = search(key, node.rightchild);
		}
		return found;
	}
	
	public void inorderPrint(){
		inorderPrint(head);
	}
	
	private void inorderPrint(BinarytreeNode node){
		if(node != null){
			inorderPrint(node.leftchild);
			System.out.println(node.element + " : " + node.count);
			inorderPrint(node.rightchild);
		}
	}
	
	public void delete(String key){
			head = delete(key, head);
			size--;
	}
	
	private BinarytreeNode delete(String key, BinarytreeNode node){
		if(node == null){
			return node;
		}
		if((node.element).compareTo(key) > 0){
			node.rightchild = delete(key, node.rightchild);
		}else if((node.element).compareTo(key) < 0){
			node.leftchild = delete(key, node.leftchild);
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
		String element;
		BinarytreeNode leftchild;
		BinarytreeNode rightchild;
		int count = 1;
		
		BinarytreeNode(String element){
			this.element = element;
			this.leftchild = null;
			this.rightchild = null;
		}
		
		BinarytreeNode(String element, BinarytreeNode leftchild, BinarytreeNode rightchild){
			this.element = element;
			this.leftchild = leftchild;
			this.rightchild = rightchild;
		}
	}
}