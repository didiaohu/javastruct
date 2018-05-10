package graph;

import com.sun.org.apache.bcel.internal.classfile.Visitor;

import base.Queue;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

public class LazyPrimMST {
	
	private double weight;     // weight ������
	private boolean[] marked;  // ��С�������Ķ���
	private Queue<Edge> mst;   // ��С�������ı�
	private MinPQ<Edge> pq;    // ���бߣ�����ʧЧ�ıߣ�
	
	public LazyPrimMST(EdgeWeightedGraph G){
		pq = new MinPQ<Edge>();
		marked = new boolean[G.V()];
		mst = new Queue<Edge>();
		visit(G, 0);    // ���� G ����ͨ��
		while(!pq.isEmpty()){
			Edge e = pq.delMin();   // ��pq�еõ�Ȩ����С�ı�
			weight += e.weight();
			int v = e.either(), w = e.other(v);
			if(marked[v] && marked[w]) continue;    // ʧЧ�ı��� continue ���˵� 
			mst.enqueue(e);
			if(!marked[v]) visit(G, v);
			if(!marked[w]) visit(G, w);
		}
	}
	
	private void visit(EdgeWeightedGraph G, int v){
		// ��Ƕ��� v ������������ v ��δ����Ƕ���ı߼��� pq
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
