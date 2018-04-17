package graph;

import java.util.Scanner;

public class CreateGraph {
    private static Graph G;
    public static Graph getGraph(){
        return G;
    }
    public static void createGraph() {
        Scanner sc = new Scanner(System.in);

        System.out.println("�����붥����v�ͱ���e:");
        int v = sc.nextInt();
        int e = sc.nextInt();
        G = new Graph(v, e);

        System.out.println("�������������Ϣ:");
        for (int i = 0; i < G.v; i++) {
            G.adjList[i] = new VertexNode();
            G.adjList[i].name = sc.next();
            G.adjList[i].firstArc = null; // ���ɻ�ȱ
        }

        System.out.println("�����������Ϣ(�ÿո����):");
        for (int i = 0; i < G.e; i++) {
            EdgeNode en1 = new EdgeNode();
            // ��֤e1,e2���ǺϷ�����
            String e1 = sc.next();
            String e2 = sc.next();
            int v1 = Index(e1);
            int v2 = Index(e2);
            en1.index = v1; // en1���±���v1
            // �����ͷ�����½�� en1
            en1.nextArc = G.adjList[v2].firstArc;
            G.adjList[v2].firstArc = en1;

            EdgeNode en2 = new EdgeNode();
            en2.index = v2; // en2���±���v2
            // �����ͷ�����½�� en2
            en2.nextArc = G.adjList[v1].firstArc;
            G.adjList[v1].firstArc = en2;
        }
    }
    public static void outputGraph() {  //��֪��Ϊ�ο�ָ���쳣
        try {
            System.out.println("����ڽӱ�洢�����");
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