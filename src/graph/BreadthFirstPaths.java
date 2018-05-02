package graph;

import base.Queue;
import base.Stack;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class BreadthFirstPaths {
	private boolean[] marked;   
	private int[] edgeTo;   
	private final int s;    // 起点
	
	public BreadthFirstPaths(Graph G, int s){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G, s);
	}
	
	private void bfs(Graph G, int s){
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;    // 标记起点
		queue.enqueue(s);    // 将它加入队列
		while(!queue.isEmpty()){
			int v = queue.dequeue();    // 从队列中删去下一个顶点
			for(int w : G.adj(v)){
				if(!marked[w]){     
					edgeTo[w] = v;     
					marked[w] = true;  // 标记它
					queue.enqueue(w);  // 并将它添加到队列中
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
		StdOut.println("输出起点 "+s+" 到各个顶点路径：");
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
