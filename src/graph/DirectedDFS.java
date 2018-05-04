package graph;

import base.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DirectedDFS {
	private boolean[] marked;
	//����ɴ���
	public DirectedDFS(Digraph G, int s) {
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	//���ɴ���
	public DirectedDFS(Digraph G, Iterable<Integer> sources) {
		marked = new boolean[G.V()];
		for(int s : sources )
			if(!marked[s]) dfs(G, s);
	}
	private void dfs(Digraph G, int v) {
		marked[v] = true;
		for(int w : G.adj(v))
			if(!marked[w]) dfs(G, w);
	}
	public boolean marked(int v) {
		return marked[v];
	}
	public static void main(String[] args) {
		Digraph G = new Digraph(new In());
		
		Bag<Integer> sources = new Bag<Integer>();
		int sourcesData[] = {1,3};  
		for(int i = 0; i < sourcesData.length; i++)
			sources.add(sourcesData[i]);
		
		// ���Զ��ɴ���
		DirectedDFS reachable = new DirectedDFS(G, sources);
		
		StdOut.println("�ɴ����ж���Ϊ��");
		for(int v = 0; v<G.V(); v++)
			if(reachable.marked(v)) StdOut.print(v + "  ");
		
	}
}