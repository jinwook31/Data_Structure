package Huffman_code;

public class MinHeap {
	private trecord[] Heap;
	private int size;
	private int maxsize;

	private static final int FRONT = 1;

	public MinHeap(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new trecord[this.maxsize + 1];
		for(int i=0; i<Heap.length;i++)  Heap[i] = new trecord();
		Heap[0].freq = Integer.MIN_VALUE;
	}

	private int parent(int pos) {
		return pos / 2;
	}

	private int leftChild(int pos) {
		return (2 * pos);
	}

	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	private boolean isLeaf(int pos) {
		if (pos >= (size / 2) && pos <= size) {
			return true;
		}
		return false;
	}

	private void swap(int fpos, int spos) {
		trecord tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

	private void minHeapify(int pos) {
		if (!isLeaf(pos)) {
			if (Heap[pos].freq > Heap[leftChild(pos)].freq
					|| Heap[pos].freq > Heap[rightChild(pos)].freq) {
				if (Heap[leftChild(pos)].freq < Heap[rightChild(pos)].freq) {
					swap(pos, leftChild(pos));
					minHeapify(leftChild(pos));
				} else {
					swap(pos, rightChild(pos));
					minHeapify(rightChild(pos));
				}
			}
		}
	}

	public void insert(trecord input) {
		Heap[++size] = input;
		int current = size;

		while (Heap[current].freq < Heap[parent(current)].freq) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	public void print() {

		for (int i = 1; i <= size / 2; i++) {
			System.out.print(" PARENT : " + Heap[i].alphabet + " LEFT CHILD : "
					+ Heap[2 * i].alphabet + " RIGHT CHILD :" + Heap[2 * i + 1].alphabet);
			System.out.println();
		}
		
		for(int i = 1; i <= size;i++){
			System.out.print(Heap[i].alphabet+" ");
		}
	}

	public void minHeap() {
		for (int pos = (size / 2); pos >= 1; pos--) {
			minHeapify(pos);
		}
	}

	public trecord remove() {
		trecord popped = Heap[FRONT];
		Heap[FRONT] = Heap[size--];
		if(size != 0)
		minHeapify(FRONT);
		return popped;
	}
}