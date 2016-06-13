package OrderedTree2;
import java.util.*;

public class OrderedTree {
	private Object root;
	private List subtrees;
	private int size;
	
	public OrderedTree(){}
	
	public OrderedTree(Object root){
		this.root = root;
		subtrees = new LinkedList();
		size = 1;
	}
	
	public OrderedTree(Object root, List trees){
		this(root);
		for(Iterator it = trees.iterator(); it.hasNext();){
			Object object = it.next();
			if(object instanceof OrderedTree){
				OrderedTree tree = (OrderedTree)object;
				subtrees.add(tree);
				size += tree.size();
			}
		}
	}
	
	public int size(){
		return size;
	}
	
	public void preOrderPrint(){
		 System.out.print(root + " ");
		 for(Iterator it = subtrees.iterator();it.hasNext();){
			 ((OrderedTree)it.next()).preOrderPrint();
		 }
	}
	
	public void levelOrderPrint(){
		LinkedList queue = new LinkedList();
		queue.addLast(this);
		System.out.print("levelorder : ");
		while(!queue.isEmpty()){
			OrderedTree tree = (OrderedTree) queue.removeFirst();
			System.out.print(tree.root + " ");
			for(Iterator it = tree.subtrees.iterator();it.hasNext();){
				queue.addLast(it.next());
			}
		}
	}
}