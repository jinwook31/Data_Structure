package Graph_DFS2;

public class DFS_test {
	public static void main (String [] args){
		Graph g = new Graph(new String[]{"SE", "UK", "DE", "FR", "CZ", "CH", "AT", "IT"});
		
		System.out.println(g); //초기 그래프 정보 출력 
		
		g.add("SE", "UK"); //Edge 추가 
		g.add("SE", "DE");
		g.add("UK", "FR");
		g.add("DE", "FR");
		g.add("DE", "IT");
		g.add("DE", "CZ");		
		g.add("CH", "FR");
		g.add("CH", "IT");
		g.add("CH", "AT");
		
		g.printNode();
		g.DFS_search();
	}
}
