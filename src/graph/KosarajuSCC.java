package graph;

import base.Queue;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class KosarajuSCC {
	private boolean[] marked;   // �ѷ��ʹ��Ķ���
	private int[] id;           // ǿ��ͨ�����ı�ʶ��
	private int count;          // ǿ��ͨ����������
	
	public KosarajuSCC(Digraph G){
		marked = new boolean[G.V()];
		id = new int[G.V()];
		DepthFirstOrder order = new DepthFirstOrder(G.reverse());
		for(int s : order.reversePost())
			if(!marked[s])
			{ dfs(G, s); count++; }
	}
	
	private void dfs(Digraph G, int v){
		marked[v] = true;
		id[v] = count;    // ��ͬһ���ڵ�ǿ��ͨ������������ͬ count ���
		for(int w : G.adj(v))
			if(!marked[w])
				dfs(G, w);
	}
	
	public boolean stronglyConnected(int v, int w)
	{ return id[v] == id[w]; }
	
	public int id(int v)
	{ return id[v]; }
	public int count()
	{ return count; }
	public static void main(String[] args) {
		Digraph G = new Digraph(new In());
		KosarajuSCC scc = new KosarajuSCC(G);
		int m = scc.count();
		
		// ǿ��ͨ��������
		StdOut.println(m + " strong components");

        Queue<Integer>[] components = (Queue<Integer>[]) new Queue[m];
        for (int i = 0; i < m; i++) {
            components[i] = new Queue<Integer>();
        }
        for (int v = 0; v < G.V(); v++) {
            components[scc.id(v)].enqueue(v);
        }
        
        // �������ǿ��ͨ����
        for (int i = 0; i < m; i++) {
            for (int v : components[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
	}
}
