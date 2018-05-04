package graph;

import base.Stack;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DirectedCycle {
	private boolean[] marked;
	private int[] edgeTo;
	private Stack<Integer> cycle; // �����е����ж��㣨������ڣ�
	private boolean[] onStack;  // �ݹ���õ�ջ�ϵ����ж���
	
	public DirectedCycle(Digraph G) {
		onStack = new boolean[G.V()];
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		for(int v = 0; v < G.V(); v++)
			if(!marked[v]) dfs(G, v);
	}
	private void dfs(Digraph G, int v) {
		onStack[v] = true;
		marked[v] = true;
		for(int w : G.adj(v))
			if(this.hasCycle()) return;
			else if(!marked[w])
			{ edgeTo[w] = v; dfs(G, w);}
			else if(onStack[w]) { // ��⵽������
				// cycle ���滷�ڵ����ж���
				cycle = new Stack<Integer>();
				for(int x = v; x!=w; x=edgeTo[x])
					cycle.push(x);
				cycle.push(w);
				cycle.push(v);
			}
		onStack[v] = false;
	}
	
	public boolean hasCycle() { 
		return cycle != null; 
	}
	public Iterable<Integer> cycle(){
		return cycle;
	}
	public static void main(String[] args) {
        Digraph G = new Digraph(new In());
        DirectedCycle finder = new DirectedCycle(G);
        if (finder.hasCycle()) {
            StdOut.print("Directed cycle: ");
            for (int v : finder.cycle()) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }else {
            StdOut.println("No directed cycle");
        }
    }
}