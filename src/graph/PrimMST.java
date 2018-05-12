package graph;

import base.Queue;
import edu.princeton.cs.algs4.IndexMinPQ;

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
			distTo[v] = Double.POSITIVE_INFINITY;
		pq = new IndexMinPQ<Double>(G.V());
		distTo[0] = 0.0;
		pq.insert(0, 0.0);   // �ö��� 0 ��Ȩ�� 0 ��ʼ�� pq
		while(!pq.isEmpty())
			visit(G, pq.delMin());   // ������Ķ�����ӵ�����
	}
	private void visit(EdgeWeightedGraph G, int v){ // ������ v ��ӵ����У���������
		marked[v] = true;
		for(Edge e : G.adj(v)){
			int w = e.other(v);
			
			if(marked[w]) continue;  // v-w ʧЧ
			if(e.weight() < distTo[w]){  // ���� w ��������ѱ� Edge ��Ϊ e
				edgeTo[w] = e;
				distTo[w] = e.weight();
				if(pq.contains(w)) pq.change(w, distTo[w]);
				else  pq.insert(w, distTo[w]);
			}
		}
	}
	public Iterable<Edge> edges(){
		Queue<Edge> mst = new Queue<Edge>();
        for (int v = 0; v < edgeTo.length; v++) {
            Edge e = edgeTo[v];
            if (e != null) {
                mst.enqueue(e);
            }
        }
        return mst;
	}
	public double weight() {
		double weight = 0.0;
        for (Edge e : edges())
            weight += e.weight();
        return weight;
    }
}
