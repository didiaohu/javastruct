package graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DepthFirstSearch {
	private boolean[] marked;  // 标记访问状态
	private int count;         // 顶点总数
	public DepthFirstSearch(Graph G, int s) { // 指定起点 s
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	
	private void dfs(Graph G, int v) {   // 深度优先算法的核心：递归调用
		marked[v] = true;
		count++;
		for(int w : G.adj(v))
			if(!marked[w]) dfs(G, w);
	}
	
	public boolean marked(int w) {  // w 与起点 s 连通吗
		return marked[w];
	}
	
	public int count() {
		return count;
	}
}	
