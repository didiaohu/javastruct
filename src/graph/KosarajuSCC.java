package graph;

import base.Queue;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class KosarajuSCC {
	private boolean[] marked;   // 已访问过的顶点
	private int[] id;           // 强连通分量的标识符
	private int count;          // 强连通分量的数量
	
	public KosarajuSCC(Digraph G){
		marked = new boolean[G.V()];
		id = new int[G.V()];
		DepthFirstOrder order = new DepthFirstOrder(G.reverse());
		for(int s : order.reversePost())
			if(!marked[s])
			{ dfs(G, s); count++; }
	}
	
	private void dfs(Digraph G, int v){
		marked[v] = true;
		id[v] = count;    // 给同一个内的强连通分量顶点做相同 count 标记
		for(int w : G.adj(v))
			if(!marked[w])
				dfs(G, w);
	}
	
	public boolean stronglyConnected(int v, int w)
	{ return id[v] == id[w]; }
	
	public int id(int v)
	{ return id[v]; }
	public int count()
	{ return count; }
	public static void main(String[] args) {
		Digraph G = new Digraph(new In());
		KosarajuSCC scc = new KosarajuSCC(G);
		int m = scc.count();
		
		// 强连通分量总数
		StdOut.println(m + " strong components");

        Queue<Integer>[] components = (Queue<Integer>[]) new Queue[m];
        for (int i = 0; i < m; i++) {
            components[i] = new Queue<Integer>();
        }
        for (int v = 0; v < G.V(); v++) {
            components[scc.id(v)].enqueue(v);
        }
        
        // 输出所有强连通分量
        for (int i = 0; i < m; i++) {
            for (int v : components[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
	}
}
