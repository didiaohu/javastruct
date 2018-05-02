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
	
	public boolean marked(int w) {
		return marked[w];
	}
	
	public int count() {
		return count;
	}
	
	public static void main(String[] args) {
		Graph G = new Graph(new In());
		int s = 0; // ָ����� s Ϊ 0
		DepthFirstSearch dfs = new DepthFirstSearch(G, s);
		StdOut.println("�������ж��㣬������£�");
		for (int v = 0; v < G.V(); v++) {
            if (dfs.marked(v))
                StdOut.print(v + " ");
        }
	}
}	
