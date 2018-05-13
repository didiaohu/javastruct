package graph;

import base.Queue;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.StdOut;

public class PrimMST {
	private Edge[] edgeTo;    // ����������ı�
	private double[] distTo;  // distTo[w] = edgeTo[w].weight()
	private boolean[] marked; // ���v��������Ϊtrue
	private IndexMinPQ<Double> pq;  // ��Ч�ĺ��б�
	
	public PrimMST(EdgeWeightedGraph G){
		edgeTo = new Edge[G.V()];
		distTo = new double[G.V()];
		marked = new boolean[G.V()];
		for(int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;   // ��ʼ���������
		pq = new IndexMinPQ<Double>(G.V());
		distTo[0] = 0.0;
		pq.insert(0, 0.0);   // ����ʼ�� 0 ��ʼ
		while(!pq.isEmpty())
			visit(G, pq.delMin());  
	}
	private void visit(EdgeWeightedGraph G, int v){ // ������ v ��ӵ����У���������
		marked[v] = true;     
		for(Edge e : G.adj(v)){
			int w = e.other(v);
			if(marked[w]) continue;  
			if(e.weight() < distTo[w]){  // Ȩֵ��С�ı�
				edgeTo[w] = e;
				distTo[w] = e.weight();
				if(pq.contains(w)) pq.change(w, distTo[w]);  // �滻����
				else  pq.insert(w, distTo[w]);               // ��Ӳ���
			}
		}
	}
	public Iterable<Edge> edges(){        // ��ȡ��С�����������б�  
		Queue<Edge> mst = new Queue<Edge>();
        for (int v = 0; v < edgeTo.length; v++) {
            Edge e = edgeTo[v];
            if (e != null) {
                mst.enqueue(e);
            }
        }
        return mst;
	}
	public double weight() {     // ��С������Ȩ����ֵ
		double weight = 0.0;
        for (Edge e : edges())
            weight += e.weight();
        return weight;
    }
    public static void main(String[] args) {
        EdgeWeightedGraph G = new EdgeWeightedGraph(new In());
        PrimMST mst = new PrimMST(G);
        StdOut.println("-------------------------");
        StdOut.println("��С��������");
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.print("��С������Ȩ����ֵ��" + mst.weight());
    }
}
