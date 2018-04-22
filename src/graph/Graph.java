package graph;

import base.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Graph {
	private final int V;  // ������Ŀ
    private int E;        // �ߵ���Ŀ
    private Bag<Integer>[] adj;  // �ڽӱ�
    public Graph(int V) {
    	this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];   // �����ڽӱ�
        for (int v = 0; v < V; v++) {        // �������ڽӱ��ʼ��Ϊ��
            adj[v] = new Bag<Integer>();
        }
    }
    public Graph(In in) {
    	this(in.readInt());        // ��ȡV����ͼ��ʼ��
    	int E = in.readInt();      // ��ȡE
    	StdOut.print("11:"+E);
    	for (int i = 0; i < E; i++) {      
    		int v = in.readInt();  // ��ȡһ������
            int w = in.readInt();  // ��ȡ��һ������
            addEdge(v, w);         // ���һ���������ǵı�
    	}
    }
    public int V() { return V; }
    public int E() { return E; }
    public void addEdge(int v, int w) {
    	adj[v].add(w);       // ��w��ӵ�v��������
    	adj[w].add(v);       // ��v��ӵ�w��������
    	E++;
    }
    public Iterable<Integer> adj(int v){
    	return adj[v];
    }
}
