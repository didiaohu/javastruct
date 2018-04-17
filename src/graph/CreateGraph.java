package graph;

import java.util.Scanner;

public class CreateGraph {
    private static Graph G;
    public static Graph getGraph(){
        return G;
    }
    public static void createGraph() {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入顶点数v和边数e:");
        int v = sc.nextInt();
        int e = sc.nextInt();
        G = new Graph(v, e);

        System.out.println("请输入各顶点信息:");
        for (int i = 0; i < G.v; i++) {
            G.adjList[i] = new VertexNode();
            G.adjList[i].name = sc.next();
            G.adjList[i].firstArc = null; // 不可或缺
        }

        System.out.println("请输入各边信息(用空格隔开):");
        for (int i = 0; i < G.e; i++) {
            EdgeNode en1 = new EdgeNode();
            // 保证e1,e2都是合法输入
            String e1 = sc.next();
            String e2 = sc.next();
            int v1 = Index(e1);
            int v2 = Index(e2);
            en1.index = v1; // en1的下标是v1
            // 链表表头插入新结点 en1
            en1.nextArc = G.adjList[v2].firstArc;
            G.adjList[v2].firstArc = en1;

            EdgeNode en2 = new EdgeNode();
            en2.index = v2; // en2的下标是v2
            // 链表表头插入新结点 en2
            en2.nextArc = G.adjList[v1].firstArc;
            G.adjList[v1].firstArc = en2;
        }
    }
    public static void outputGraph() {  //不知道为何空指针异常
        try {
            System.out.println("输出邻接表存储情况：");
            EdgeNode en = new EdgeNode();
            for (int i = 0; i < G.e; i++) {
                System.out.print(G.adjList[i].name);
                en = G.adjList[i].firstArc;
                while (en != null) {
                    System.out.print("->" + G.adjList[en.index].name);
                    en = en.nextArc;
                }
                System.out.println();
            }
        } catch (NullPointerException e) {

        }

    }
    private static int Index(String e1) {
        for (int i = 0; i < G.v; i++) {
            if (G.adjList[i].name.equals(e1)){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        CreateGraph.createGraph();
        CreateGraph.outputGraph();
    }
}