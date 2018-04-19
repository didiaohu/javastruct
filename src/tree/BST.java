package tree;

import java.util.NoSuchElementException;

import base.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BST<Key extends Comparable<Key>, Value> {
	private Node root;      // 二叉查找树的根结点
	private class Node{
		private Key key;    // 键
		private Value val;  // 值
		private Node left, right;   // 指向子树的链接
		private int size;  // 以该结点为根的子树中的结点总数
		
		public Node(Key key, Value val, int size) {
			this.key = key;
			this.val = val;
			this.size = size;
		}
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(Node x) {
		if(x == null) return 0;
		else return x.size;
	}
	
	public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
    	// 在以 x 为根结点的子树中查找并返回 key 所对应的值
        if (key == null) throw new IllegalArgumentException("calls get() with a null key");
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }
    
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }
    
    public Key min() {
        return min(root).key;
    } 

    private Node min(Node x) { 
        if (x.left == null) return x; 
        else     return min(x.left); 
    }
    
    public Key max() {
        return max(root).key;
    } 

    private Node max(Node x) {
        if (x.right == null) return x; 
        else      return max(x.right); 
    }
    
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    
    public void deleteMax() {
        root = deleteMax(root);
    }
    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else { 
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public static void main(String[] args) {
    	BST<String, Integer> st = new BST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

//        for (String s : st.levelOrder())
//            StdOut.println(s + " " + st.get(s));
//
//        StdOut.println();
//
//        for (String s : st.keys())
//            StdOut.println(s + " " + st.get(s));
	}
}
