package graph;


import base.Stack;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DepthFirstPaths {
	private boolean[] marked;   
	private int[] edgeTo;      // ����㵽һ���������֪·���ϵ�ǰһ������
	private final int s;      // ���
	
	public DepthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);
	}
	private void dfs(Graph G, int v) {
		marked[v] = true;
		for(int w : G.adj(v))
			if(!marked[w]) {
				edgeTo[w] = v;  // v �� w ��ǰһ������
				dfs(G, w);
			}
	}
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	public Iterable<Integer> pathTo(int v){   // ���ش���㵽ָ������ v ��·�� 
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int x = v; x != s; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}
	public static void main(String[] args) {
		In in = new In();
		Graph G = new Graph(new In());
		int s = 0;
		DepthFirstPaths dfs = new DepthFirstPaths(G, s);
		StdOut.println("������ "+s+" ����������·����");
		for (int v = 0; v < G.V(); v++) {	
			if (dfs.hasPathTo(v)) {
				StdOut.printf("%d to %d:  ", s, v);
				for(int x : dfs.pathTo(v)) {
					if (x == s) StdOut.print(x);
                    else        StdOut.print("-" + x);
				}
				StdOut.println();
			}
		}
	}
}
