package graph;

import base.Queue;
import base.Stack;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DepthFirstOrder {
	private boolean[] marked;   
	private Queue<Integer> pre;          // 所有顶点的前序排列
	private Queue<Integer> post;         // 所有顶点的后序排列
	private Stack<Integer> reversePost;  // 所有顶点的逆后序排列
	
	public DepthFirstOrder(Digraph G) {
		pre = new Queue<Integer>();
		post = new Queue<Integer>();
		reversePost = new Stack<Integer>();
		marked = new boolean[G.V()];
		
		for(int v = 0; v < G.V(); v++)
			if(!marked[v]) dfs(G, v);
	}
	private void dfs(Digraph G, int v) {
		pre.enqueue(v);
		marked[v] = true;
		for(int w : G.adj(v))
			if(!marked[w])
				dfs(G, w);
		post.enqueue(v);
		reversePost.push(v);
	}
	public Iterable<Integer> pre(){
		return pre;
	}
	public Iterable<Integer> post(){
		return post;
	}
	public Iterable<Integer> reversePost(){
		return reversePost;
	}
	public static void main(String[] args) {
        In in = new In();
        Digraph G = new Digraph(in);

        DepthFirstOrder dfs = new DepthFirstOrder(G);
        StdOut.println("--------------");

        StdOut.print("Preorder:  ");
        for (int v : dfs.pre()) {
            StdOut.print(v + " ");
        }
        StdOut.println();

        StdOut.print("Postorder: ");
        for (int v : dfs.post()) {
            StdOut.print(v + " ");
        }
        StdOut.println();

        StdOut.print("Reverse postorder: ");
        for (int v : dfs.reversePost()) {
            StdOut.print(v + " ");
        }
        StdOut.println();


    }
}
