package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleUndirected {
    public static int detectCycle(int A, int[][] B){

        // 1. convert edge-list to adjacency list
        int N = B.length;
        ArrayList<Integer>[] adlist = new ArrayList[A+1];

        for(int i=0;i<=A;i++){
            adlist[i] = new ArrayList<>();
        }

        for(int i=0;i<N;i++){
            int u = B[i][0];
            int v = B[i][1];

            adlist[u].add(v);
            adlist[v].add(u);
        }

        // 2. initialise visited list
        boolean[] visited = new boolean[A+1];

        // 3. Core idea - if you reach a visited node other than its parent,
        // a cycle exists

        Queue<int[]> queue = new LinkedList<>();

        for(int i=1;i<=A;i++){
            if(!visited[i]){
                visited[i] = true;
                queue.add(new int[]{i,-1});


                while (!queue.isEmpty()){
                    int[] pair = queue.poll();
                    int currentNode = pair[0];
                    int parent = pair[1];

                    for(int neighbour : adlist[currentNode]){
                        if(!visited[neighbour]){
                            visited[neighbour] = true;
                            queue.add(new int[]{neighbour,currentNode});
                        } else if ( neighbour != parent) {
                            return 1;  // cycle detected
                        }
                    }
                }
            }
        }
        return 0;

    }
    public static void main(String[] args) {
        int A = 5;
        int[][] B = {
                {1,2},
                {1,3},
                {1,4},
                {2,3},
                {4,5}
        }; // cycle

        System.out.println(detectCycle(A,B));
    }
}
