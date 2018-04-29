package graph;

import base.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Digraph {
	private final int V;  // 结点数 
	private int E;        // 边数
	private Bag<Integer>[] adj;  // 邻接表
	public Digraph(int V){
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int v = 0; v < V; v++)
			adj[v] = new Bag<Integer>();
	}
    public Digraph(In in) {
        this.V = in.readInt();    // 读取V并将图初始化
        adj = (Bag<Integer>[]) new Bag[V];   
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
        int E = in.readInt();      // 读取E
        for (int i = 0; i < E; i++) {
            int v = in.readInt();  // 读取一个顶点
            int w = in.readInt();  // 读取另一个顶点
            addEdge(v, w);         // 添加一条连接它们的边
        }
    }
	public int V(){return V;}
	public int E(){return E;}
	public void addEdge(int v, int w){
		adj[v].add(w);
		E++;
	}
	public Iterable<Integer> adj(int v){  
		return adj[v];
	}
	public Digraph reverse(){   // 该图的反向图
		Digraph R = new Digraph(V);
		for(int v = 0; v < V; v++)
			for(int w:adj(v))
				R.addEdge(w, v);
		return R;
	}
	public static void main(String[] args) {
        In in = new In();
        Digraph G = new Digraph(in);
        StdOut.println(G);
    }
}
