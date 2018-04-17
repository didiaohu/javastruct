package graph;

public class Graph {
    VertexNode[] adjList; // �ڽӱ�
    int e; // ͼ�ı���
    int v; // ͼ�Ķ�����
    boolean[] visit;

    public Graph(int v, int e) {
        this.v = v;
        this.e = e;
        adjList = new VertexNode[e + 1]; 
        visit = new boolean[e + 1];  //���
        for (int i = 0; i < e; i++) {
            visit[i] = false;
        }
    }
}
