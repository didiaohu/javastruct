package graph;

import base.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class EdgeWeightedDigraph {
	private static final String NEWLINE = System.getProperty("line.separator");  // 换行
	private final int V;                // 顶点总数 
	private int E;                      // 边的总数
	private Bag<DirectedEdge>[] adj;    // 邻接表
	public EdgeWeightedDigraph(int V){
		this.V = V;
		this.E = 0;
		adj = (Bag<DirectedEdge>[]) new Bag[V];
		for(int v = 0; v < V; v++)
			adj[v] = new Bag<DirectedEdge>();
	}
	public EdgeWeightedDigraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(new DirectedEdge(v, w, weight));
        }
    }
	public int V(){
		return V;
	}
	public int E(){
		return E;
	}
	public void addEdge(DirectedEdge e){  // 将 e 添加到该有向图中
		adj[e.from()].add(e);
		E++;
	}
	public Iterable<DirectedEdge> adj(int v) {  // 从 v 指出的边
        return adj[v];
    }
	public Iterable<DirectedEdge> edges(){  // 该有向图中的所有边
		Bag<DirectedEdge> bag = new Bag<DirectedEdge>();
		for(int v = 0; v < V; v++)
			for(DirectedEdge e : adj[v])
				bag.add(e);
		return bag;
	}
	
    public String toString() {  // 对象的字符串表示
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (DirectedEdge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
	public static void main(String[] args) {
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In());
		StdOut.println("----------------------");
		StdOut.println("加权有向图输出结果：");
        StdOut.println(G);
	}
}
