package graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Topological {
	private Iterable<Integer> order;    // 顶点的拓扑排序
	public Topological(Digraph G) {
		DirectedCycle cyclefinder = new DirectedCycle(G); 
		if(!cyclefinder.hasCycle()) {   // 判断图是否有无环
			DepthFirstOrder dfs = new DepthFirstOrder(G);   
			order = dfs.reversePost();  // 逆后序
		}
	}
	public Iterable<Integer> order(){
		return order;
	}
	public boolean isDAG() {
		return order != null;
	}
	public static void main(String[] args) {
		Digraph G = new Digraph(new In());   // 以图 3 为例
		Topological top = new Topological(G);
		StdOut.println("拓扑排序：");
		for(int v : top.order())
			StdOut.print(v+" ");
	}
}
