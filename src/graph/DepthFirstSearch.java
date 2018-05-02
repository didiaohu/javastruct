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
	
	public boolean marked(int w) {
		return marked[w];
	}
	
	public int count() {
		return count;
	}
	
	public static void main(String[] args) {
		Graph G = new Graph(new In());
		int s = 0; // 指定起点 s 为 0
		DepthFirstSearch dfs = new DepthFirstSearch(G, s);
		StdOut.println("遍历所有顶点，结果如下：");
		for (int v = 0; v < G.V(); v++) {
            if (dfs.marked(v))
                StdOut.print(v + " ");
        }
	}
}	
