package graph;

import java.util.LinkedList;
import java.util.Queue;

/* �ڽӱ�洢��ͼ �C BFS */
public class BFSGraph {
    public static void BFS(Graph G) {
        /* ��������ȱ���ͼG��ʹ�ø�������Q�ͷ��ʱ�־����visit */
        Integer v;
        EdgeNode p;
        Queue<Integer> que = new LinkedList<Integer>();   /* �����ն���Q */
        for(int u = 0; u < G.v; u++){
            if(G.visit[u] != true){   /* ��U��δ���� */
                G.visit[u] = true;
                System.out.println(G.adjList[u].name);  /* �൱�ڷ��ʶ���U */       
                que.offer(u);  /* U����� */
                while(!que.isEmpty()){
                    v = que.poll();   /*  ��ͷԪ�س��Ӳ���ΪV */
                    p = G.adjList[v].firstArc;
                    while(p != null){
                        if(!G.visit[p.index]){
                            G.visit[p.index] = true;
                            System.out.println(G.adjList[p.index].name);  /* �൱�ڷ���Ҫ��ӵĶ��� */
                            que.offer(p.index);  
                        } 
                        p = p.nextArc;    
                    }
                }
            }
        }
    }
}