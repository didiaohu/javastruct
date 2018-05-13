package graph;

import base.Queue;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.StdOut;

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
			distTo[v] = Double.POSITIVE_INFINITY;   // 初始化正无穷大
		pq = new IndexMinPQ<Double>(G.V());
		distTo[0] = 0.0;
		pq.insert(0, 0.0);   // 从起始点 0 开始
		while(!pq.isEmpty())
			visit(G, pq.delMin());  
	}
	private void visit(EdgeWeightedGraph G, int v){ // 将顶点 v 添加到树中，更新数据
		marked[v] = true;     
		for(Edge e : G.adj(v)){
			int w = e.other(v);
			if(marked[w]) continue;  
			if(e.weight() < distTo[w]){  // 权值最小的边
				edgeTo[w] = e;
				distTo[w] = e.weight();
				if(pq.contains(w)) pq.change(w, distTo[w]);  // 替换操作
				else  pq.insert(w, distTo[w]);               // 入队操作
			}
		}
	}
	public Iterable<Edge> edges(){        // 获取最小生成树的所有边  
		Queue<Edge> mst = new Queue<Edge>();
        for (int v = 0; v < edgeTo.length; v++) {
            Edge e = edgeTo[v];
            if (e != null) {
                mst.enqueue(e);
            }
        }
        return mst;
	}
	public double weight() {     // 最小生成树权重总值
		double weight = 0.0;
        for (Edge e : edges())
            weight += e.weight();
        return weight;
    }
    public static void main(String[] args) {
        EdgeWeightedGraph G = new EdgeWeightedGraph(new In());
        PrimMST mst = new PrimMST(G);
        StdOut.println("-------------------------");
        StdOut.println("最小生成树：");
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.print("最小生成树权重总值：" + mst.weight());
    }
}
