package tree;

import edu.princeton.cs.algs4.StdOut;

public class Node {
	String data;
	Node left;
	Node right;
	public void preOrder(Node root){
		if(root != null){
			StdOut.print(root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	public void inOrder(Node root){
		if(root != null){
			preOrder(root.left);
			StdOut.print(root.data);
			preOrder(root.right);
		}
	}
	public void postOrder(Node root){
		if(root != null){
			preOrder(root.left);
			preOrder(root.right);
			StdOut.print(root.data);
		}
	}
	public static void main(String[] args) {
		Node root = new Node();
		root.data = "a";

		Node second = new Node();
		second.data = "b";

		Node third = new Node();
		third.data = "c";

		root.left = second;
		root.right = third;
		
		root.preOrder(root);
		root.inOrder(root);
		root.postOrder(root);
	}
}
