package OrderedTree;
import java.util.*;

public class TestTree {
	public static void main (String [] args){
		OrderedTree treeA, treeB, treeD;
		OrderedTree treeE = new OrderedTree("E");
		OrderedTree treeC = new OrderedTree("C");
		OrderedTree treeF = new OrderedTree("F");
		OrderedTree treeG = new OrderedTree("G");
		
		List subtreesOfB = new LinkedList();
		subtreesOfB.add(treeE);
		subtreesOfB.add(treeF);
		treeB = new OrderedTree("B", subtreesOfB);
		
		List subtreesOfD = new LinkedList();
		subtreesOfD.add(treeG);
		treeD = new OrderedTree("D", subtreesOfD);
		
		List subtreesOfA = new LinkedList();
		subtreesOfA.add(treeB);
		subtreesOfA.add(treeC);
		subtreesOfA.add(treeD);
		treeA = new OrderedTree("A", subtreesOfA);
	}
}
