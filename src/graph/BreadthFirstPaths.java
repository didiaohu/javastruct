package graph;

import base.Queue;
import base.Stack;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class BreadthFirstPaths {
	private boolean[] marked;   
	private int[] edgeTo;   
	private final int s;    // ���
	
	public BreadthFirstPaths(Graph G, int s){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G, s);
	}
	
	private void bfs(Graph G, int s){
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;    // ������
		queue.enqueue(s);    // �����������
		while(!queue.isEmpty()){
			int v = queue.dequeue();    // �Ӷ�����ɾȥ��һ������
			for(int w : G.adj(v)){
				if(!marked[w]){     
					edgeTo[w] = v;     
					marked[w] = true;  // �����
					queue.enqueue(w);  // ��������ӵ�������
				}
			}
		}
	}
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int x = v; x != s; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}
	public static void main(String[] args) {
		In in = new In();
		Graph G = new Graph(new In());
		int s = 0;
		BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
		StdOut.println("������ "+s+" ����������·����");
		for (int v = 0; v < G.V(); v++) {	
			if (bfs.hasPathTo(v)) {
				StdOut.printf("%d to %d:  ", s, v);
				for(int x : bfs.pathTo(v)) {
					if (x == s) StdOut.print(x);
                    else        StdOut.print("-" + x);
				}
				StdOut.println();
			}
		}
	}
}
