package graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DepthFirstSearch {
	private boolean[] marked;  // ��Ƿ���״̬
	private int count;         // ��������
	public DepthFirstSearch(Graph G, int s) { // ָ����� s
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	
	private void dfs(Graph G, int v) {   // ��������㷨�ĺ��ģ��ݹ����
		marked[v] = true;
		count++;
		for(int w : G.adj(v))
			if(!marked[w]) dfs(G, w);
	}
	
	public boolean marked(int w) {  // w ����� s ��ͨ��
		return marked[w];
	}
	
	public int count() {
		return count;
	}
}	
