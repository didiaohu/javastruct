package graph;

public class Graph {
    VertexNode[] adjList; // 邻接表
    int e; // 图的边数
    int v; // 图的顶点数
    boolean[] visit;

    public Graph(int v, int e) {
        this.v = v;
        this.e = e;
        adjList = new VertexNode[e + 1]; 
        visit = new boolean[e + 1];  //标记
        for (int i = 0; i < e; i++) {
            visit[i] = false;
        }
    }
}
