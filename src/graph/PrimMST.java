package graph;

import base.Queue;
import edu.princeton.cs.algs4.IndexMinPQ;

public class PrimMST {
	private Edge[] edgeTo;    // 距离树最近的边
	private double[] distTo;  // distTo[w] = edgeTo[w].weight()
	private boolean[] marked; // 如果v在树中则为true
	private IndexMinPQ<Double> pq;  // 有效的横切边
	
	public PrimMST(EdgeWeightedGraph G){
		edgeTo = new Edge[G.V()];
		distTo = new double[G.V()];
		marked = new boolean[G.V()];
		for(int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		pq = new IndexMinPQ<Double>(G.V());
		distTo[0] = 0.0;
		pq.insert(0, 0.0);   // 用顶点 0 和权重 0 初始化 pq
		while(!pq.isEmpty())
			visit(G, pq.delMin());   // 将最近的顶点添加到树中
	}
	private void visit(EdgeWeightedGraph G, int v){ // 将顶点 v 添加到树中，更新数据
		marked[v] = true;
		for(Edge e : G.adj(v)){
			int w = e.other(v);
			
			if(marked[w]) continue;  // v-w 失效
			if(e.weight() < distTo[w]){  // 连接 w 和树的最佳边 Edge 变为 e
				edgeTo[w] = e;
				distTo[w] = e.weight();
				if(pq.contains(w)) pq.change(w, distTo[w]);
				else  pq.insert(w, distTo[w]);
			}
		}
	}
	public Iterable<Edge> edges(){
		Queue<Edge> mst = new Queue<Edge>();
        for (int v = 0; v < edgeTo.length; v++) {
            Edge e = edgeTo[v];
            if (e != null) {
                mst.enqueue(e);
            }
        }
        return mst;
	}
	public double weight() {
		double weight = 0.0;
        for (Edge e : edges())
            weight += e.weight();
        return weight;
    }
}
