package DS_Performance_AVL_BST_HT_LL;

public class HashTable implements Map_interface{
	private Entry[] entries;
	private int size, used;
	private float loadFactor;
	private final Entry NIL = new Entry(null, null);
	private int collision = 0;
	private int mode = 0;
	
	public HashTable(int capacity, float loadFactor) {
		entries = new Entry[capacity];
		this.loadFactor = loadFactor;
	}
	
	public HashTable(int capacity) {
		this(capacity, 0.75F);
	}
	
	public HashTable() {
		this(101);
	}
	
	public int getCollision(){
		return collision;
	}
	
	public void setMode(int mode){
		this.mode = mode;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		int h = hash(key);
		for(int i = 0; i < entries.length; i++){
			int j = nextProbe(h,0,i);
			Entry entry = entries[j];
			if(entry == null) break;
			if(entry == NIL) continue;
			if(entry.key.equals(key)) return entry.value;
		}
		return null;  //key not found
	}
	
	@Override
	public Object put(Object key, Object value) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.print(key);
		
		if(used > loadFactor * entries.length) rehash();
		int h = hash(key);
		int h2 = hash2(key);
		for(int i = 0; i < entries.length; i++){		
			int j = nextProbe(h, h2, i);
			
			System.out.print(" -> " + j);
			
			Entry entry = entries[j];
			if(entry == null){				
				entries[j] = new Entry(key, value);			
				++size;
				++used;
				return null;
			}			
			if(entry == NIL) continue;
			if(entry.key.equals(key)){
				Object oldValue = entry.key;
				entries[j].value = value;
				return oldValue; //update success
			}
			
			collision++;
		
		}
		return null;  //failure  table overflow
	}

	@Override
	public Object remove(Object key) {
		// TODO Auto-generated method stub
		int h = hash(key);
		for(int i =0; i < entries.length; i++){
			int j = nextProbe(h,0,i);
			Entry entry = entries[j];
			if(entry == null) break;
			if(entry == NIL) continue;
			if(entry.key.equals(key)){
				Object oldValue = entry.value;
				entries[j] = NIL;
				--size;
				return oldValue;    //success
			}
		}
		return null;     //failure: key not found
	}

	private class Entry{
		Object key, value;
		Entry(Object k, Object v) {key = k; value = v;}
	}
	
	private int hash(Object key){
		if(key == null) throw new IllegalArgumentException();
		return (key.hashCode() & 0x7FFFFFFF) % entries.length;
	}
	
	private int hash2(Object key){
		if(key == null) throw new IllegalArgumentException();
		return 1 + (key.hashCode() & 0x7FFFFFFF) % (entries.length-1);
	}
	
	private int nextProbe(int h, int h2, int i){
		if(mode == 0) return linearProbe(h,i);
		else if(mode == 1) return quadraticProbe(h,i);
		else return doubleHashing(h,h2,i);
	}
	
	private int linearProbe(int h, int i){
		return (h + i) % entries.length;  //Linear Probing
	}
	
	private int quadraticProbe(int h, int i){
		return (h + i*i) % entries.length;   //quadratic Probe
	}
	
	private int doubleHashing(int h, int h2, int i) {
		return (h + h2*i)%entries.length; // Double Hashing
	}
	
	private void rehash(){
		Entry[] oldEntries = entries;
		entries = new Entry[2*oldEntries.length+1];
		for (int k = 0; k < oldEntries.length; k++) {
			Entry entry = oldEntries[k];
			if (entry == null || entry == NIL) continue;
			int h = hash(entry.key);
			int h2 = hash2(entry.key);
			for (int i = 0; i < entries.length; i++) {
				int j = nextProbe(h, h2, i);
				
				if (entries[j] == null){
					entries[j] = entry;
					break;
				}
			}
		}
	used = size;
	}
}
