package HashTable;

public class Test {
	public static void main (String [] args){
		
		for(int i=0; i < 3; i++){
			HashTable h = new HashTable(17);
			h.setMode(i);
			
			if(i == 0)	System.out.print("Linear Probing:");
			if(i == 1)	System.out.print("Quadratic Probing:");
			if(i == 2)	System.out.print("Double Hashing:");
			
			h.put("AT", new Country("Austria", "German",32378, 8139299));
			h.put("BE", new Country("Belgium", "Dutch",11800, 1018234));
			h.put("DE", new Country("Germany", "German",137800, 82087361));
			h.put("DK", new Country("Denmark", "Danish",16639, 5356845));
			h.put("ES", new Country("Spain", "Spanish",194880, 39167744));
			h.put("FR", new Country("France", "French",211200, 58978172));
			h.put("IT", new Country("Italy", "Italian",116300, 8139299));
			h.put("LU", new Country("Luxembourg", "French",998, 429080));
			h.put("SE", new Country("Sweden", "Portuguese",35672, 9918040));
			
			System.out.println();
			System.out.println(h.getCollision() + " Collisions");
		}
		
	}
}

class Country{
	String name1, name2;
	int index1;
	float index2;
	
	public Country(String name1, String name2, int index1, float index2){
		this.name1 = name1;
		this.name2 = name2;
		this.index1 = index1;
		this.index2 = index2;
	}
}