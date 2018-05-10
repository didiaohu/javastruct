package graph;

import com.sun.org.apache.bcel.internal.classfile.Visitor;

import base.Queue;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

public class LazyPrimMST {
	
	private double weight;     // weight 的总数
	private boolean[] marked;  // 最小生成树的顶点
	private Queue<Edge> mst;   // 最小生成树的边
	private MinPQ<Edge> pq;    // 横切边（包括失效的边）
	
	public LazyPrimMST(EdgeWeightedGraph G){
		pq = new MinPQ<Edge>();
		marked = new boolean[G.V()];
		mst = new Queue<Edge>();
		visit(G, 0);    // 假设 G 是连通的
		while(!pq.isEmpty()){
			Edge e = pq.delMin();   // 从pq中得到权重最小的边
			weight += e.weight();
			int v = e.either(), w = e.other(v);
			if(marked[v] && marked[w]) continue;    // 失效的边用 continue 过滤掉 
			mst.enqueue(e);
			if(!marked[v]) visit(G, v);
			if(!marked[w]) visit(G, w);
		}
	}
	
	private void visit(EdgeWeightedGraph G, int v){
		// 标记顶点 v 并将所有连接 v 和未被标记顶点的边加入 pq
		marked[v] = true;
		for(Edge e: G.adj(v))
			if(!marked[e.other(v)]) pq.insert(e);
	}
	public Iterable<Edge> edges(){
		return mst;
	}
	public double weight() {
        return weight;
    }
	public static void main(String[] args) {
		
		for(int i =0; i < 10; i++){
			if(i==5) continue;
			StdOut.println(i);
		}
	}
}
