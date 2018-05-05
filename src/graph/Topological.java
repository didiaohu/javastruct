package graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Topological {
	private Iterable<Integer> order;    // �������������
	public Topological(Digraph G) {
		DirectedCycle cyclefinder = new DirectedCycle(G); 
		if(!cyclefinder.hasCycle()) {   // �ж�ͼ�Ƿ����޻�
			DepthFirstOrder dfs = new DepthFirstOrder(G);   
			order = dfs.reversePost();  // �����
		}
	}
	public Iterable<Integer> order(){
		return order;
	}
	public boolean isDAG() {
		return order != null;
	}
	public static void main(String[] args) {
		Digraph G = new Digraph(new In());   // ��ͼ 3 Ϊ��
		Topological top = new Topological(G);
		StdOut.println("��������");
		for(int v : top.order())
			StdOut.print(v+" ");
	}
}
