package graph;

import base.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Digraph {
	private final int V;  // ����� 
	private int E;        // ����
	private Bag<Integer>[] adj;  // �ڽӱ�
	public Digraph(int V){
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int v = 0; v < V; v++)
			adj[v] = new Bag<Integer>();
	}
    public Digraph(In in) {
        this.V = in.readInt();    // ��ȡV����ͼ��ʼ��
        adj = (Bag<Integer>[]) new Bag[V];   
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
        int E = in.readInt();      // ��ȡE
        for (int i = 0; i < E; i++) {
            int v = in.readInt();  // ��ȡһ������
            int w = in.readInt();  // ��ȡ��һ������
            addEdge(v, w);         // ���һ���������ǵı�
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
	public Digraph reverse(){   // ��ͼ�ķ���ͼ
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
