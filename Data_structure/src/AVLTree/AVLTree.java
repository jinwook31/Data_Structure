package AVLTree;


class AVLTree {
	private AVLNode root;

	public AVLTree() {
		root = null;
	}	

	private int height(AVLNode t) {
		return t == null ? -1 : t.height;
	}

	public void add(int key) {
		root = grow(key, root);
	}

	private AVLNode grow(int x, AVLNode t) {
		if (t == null)
			t = new AVLNode(x);
		else if (x < t.data) {
			t.left = grow(x, t.left);
			if (height(t.left) - height(t.right) == 2)
				if (x < t.left.data)
					t = rotateWithLeftChild(t);
				else
					t = doubleWithLeftChild(t);
		} else if (x > t.data) {
			t.right = grow(x, t.right);
			if (height(t.right) - height(t.left) == 2)
				if (x > t.right.data)
					t = rotateWithRightChild(t);
				else
					t = doubleWithRightChild(t);
		} else{ }
			
		t.height = Math.max(height(t.left), height(t.right)) + 1;
		return t;
	}

	private AVLNode rotateWithLeftChild(AVLNode k2) {
		AVLNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
		k1.height = Math.max(height(k1.left), k2.height) + 1;
		return k1;
	}

	private AVLNode rotateWithRightChild(AVLNode k1) {
		AVLNode k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
		k2.height = Math.max(height(k2.right), k1.height) + 1;
		return k2;
	}
	private AVLNode doubleWithLeftChild(AVLNode k3) {
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}

	private AVLNode doubleWithRightChild(AVLNode k1) {
		k1.right = rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}
	
	
	

	public boolean search(int val) {
		return search(root, val);
	}

	private boolean search(AVLNode r, int val) {
		boolean found = false;
		while ((r != null) && !found) {
			int rval = r.data;
			if (val < rval)
				r = r.left;
			else if (val > rval)
				r = r.right;
			else {
				found = true;
				break;
			}
			found = search(r, val);
		}
		return found;
	}

	public void inorder() {
		inorder(root);
	}

	private void inorder(AVLNode r) {
		if (r != null) {
			inorder(r.left);
			System.out.print(r.data + " ");
			inorder(r.right);
		}
	}
	
	private class AVLNode {
		AVLNode left, right;
		int data;
		int height;

		public AVLNode(int n) {
			left = null;
			right = null;
			data = n;
			height = 0;
		}
	}
}