package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheckBipartite {
    public static int checkBipartite(int A, int[][] B) {
        // 1. convert edge lost to adjacency list
        ArrayList<Integer>[] adlist = new ArrayList[A];
        for(int i=0;i<A;i++){
            adlist[i] = new ArrayList<>();
        }

        int M = B.length;

        for(int i=0;i<M;i++){
            int u = B[i][0];
            int v = B[i][1];

            adlist[u].add(v);
            adlist[v].add(u);
        }

        int[] colored = new int[A];
        Arrays.fill(colored,-1);

        // 2. check nodes if colored, if not start
        // start bfs from that node
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<A;i++){

            if(colored[i] == -1){

                // bfs start
                colored[i] = 1;
                queue.add(i);

                while(!queue.isEmpty()){
                    int node = queue.poll();

                    for(int neighbour : adlist[node]){
                        if(colored[neighbour] == -1 ){

                            colored[neighbour] = 1 - colored[node];
                            queue.add(neighbour);
                        }else if(colored[node] == colored[neighbour]){
                            return 0;
                        }
                    }
                }
            }

        }

        return 1;

    }
    public static void main(String[] args) {
        int A = 3;
        /*int[][] B = {
                {0,1},
                {1,2},
                {1,0},
        }; // bipartite*/
        int[][] B = {
                {0,1},
                {0,2},
                {1,2}
        }; // not bipartite
        System.out.println(checkBipartite(A,B));
    }
}
