package graph;

import java.util.LinkedList;
import java.util.Queue;

/* 邻接表存储的图 – BFS */
public class BFSGraph {
    public static void BFS(Graph G) {
        /* 按广度优先遍历图G。使用辅助队列Q和访问标志数组visit */
        Integer v;
        EdgeNode p;
        Queue<Integer> que = new LinkedList<Integer>();   /* 创建空队列Q */
        for(int u = 0; u < G.v; u++){
            if(G.visit[u] != true){   /* 若U尚未访问 */
                G.visit[u] = true;
                System.out.println(G.adjList[u].name);  /* 相当于访问顶点U */       
                que.offer(u);  /* U入队列 */
                while(!que.isEmpty()){
                    v = que.poll();   /*  队头元素出队并置为V */
                    p = G.adjList[v].firstArc;
                    while(p != null){
                        if(!G.visit[p.index]){
                            G.visit[p.index] = true;
                            System.out.println(G.adjList[p.index].name);  /* 相当于访问要入队的顶点 */
                            que.offer(p.index);  
                        } 
                        p = p.nextArc;    
                    }
                }
            }
        }
    }
}