package graph;

import base.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Graph {
	private static final String NEWLINE = System.getProperty("line.separator"); // ����չʾ
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
    public Iterable<Integer> adj(int v){ // ��ȡ���� v �������ڽӵ�
    	return adj[v];
    }
    public String toString() {  // ���ַ�����ʾ�ڽӱ�
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
    public static void main(String[] args) {
		Graph G = new Graph(new In());
		StdOut.println(G);  // �ȼ��ڵ��� G.toString() 
	}
}
