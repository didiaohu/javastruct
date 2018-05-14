package graph;

import base.Queue;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.UF;

public class KruskalMST {
	private double weight;  // 最小生成树权重总值
	private Queue<Edge> mst = new Queue<Edge>();  
	public KruskalMST(EdgeWeightedGraph G){
		MinPQ<Edge> pq = new MinPQ<Edge>();
		for (Edge e : G.edges()) {
			pq.insert(e);  
		}
		
		UF uf = new UF(G.V());
		
		while(!pq.isEmpty() && mst.size() < G.V()-1){
			Edge e = pq.delMin();   
			int v = e.either(), w = e.other(v);
			if(uf.connected(v, w)) continue;  // 忽略失效的边
			uf.union(v, w);   // 合并分量
			mst.enqueue(e);   // 将边添加到最小生成树中
			weight += e.weight();
		}
	}
	public Iterable<Edge> edges(){
		return mst;
	}
	public double weight(){
		return weight;
	}
	public static void main(String[] args) {
        EdgeWeightedGraph G = new EdgeWeightedGraph(new In());
        KruskalMST mst = new KruskalMST(G);
        StdOut.println("-------------------------");
        StdOut.println("最小生成树：");
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.println("最小生成树权重总值：" + mst.weight());
	}
}
