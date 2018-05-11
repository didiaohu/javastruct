package graph;

import base.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class EdgeWeightedGraph {
	private static final String NEWLINE = System.getProperty("line.separator"); // ����չʾ
	private final int V;     // ��������
	private int E;           // �ߵ�����
	private Bag<Edge>[] adj; // �ڽӱ�
	public EdgeWeightedGraph(int V){  // ����һ����V�������ͼ
		this.V = V;
		this.E = 0;
		adj = (Bag<Edge>[]) new Bag[V];
		for(int v = 0; v < V; v++)
			adj[v] = new Bag<Edge>();
	}
	public EdgeWeightedGraph(In in){  // ���������ж�ȡͼ
		this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            Edge e = new Edge(v, w, weight);
            addEdge(e);
        }
	}
	public int V(){ return V; }  
	public int E(){ return E; }
	public void addEdge(Edge e){   // ��ͼ�����һ���� e
		int v = e.either(), w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}
	public Iterable<Edge> adj(int v){  // ��v����������б�
		return adj[v];
	}
	public Iterable<Edge> edges(){  // ͼ�����б�
		Bag<Edge> list = new Bag<Edge>();
        for (int v = 0; v < V; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {  
                    list.add(e);
                }
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) list.add(e);
                    selfLoops++;
                }
            }
        }
        return list;
	}
	public String toString() {   // ������ַ�����ʾ
        StringBuilder s = new StringBuilder();
        s.append("���㣺" + V + " �ߣ�" + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (Edge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
	public static void main(String[] args) {
		EdgeWeightedGraph G = new EdgeWeightedGraph(new In());
		StdOut.println("-------------------------");
        StdOut.println(G);
	}
}
