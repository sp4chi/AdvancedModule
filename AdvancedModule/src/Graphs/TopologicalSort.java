package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort{
    public static void topologicalSort(int N, int[][] graph){

        // 1. build adjacency list of directed graph
        ArrayList<Integer>[] adlist = new ArrayList[N];
        for(int i=0;i<N;i++){
            adlist[i] = new ArrayList<>();
        }

        for(int i=0;i<graph.length;i++){
            int u = graph[i][0];
            int v = graph[i][1];

            adlist[u].add(v);
        }

        int[] indegree = new int[N];
        boolean[] visited = new boolean[N];

        // 2. build the indegree array,
        // purpose -> to find the starting node, starting nodes have indegree 0.
        for(int u=0;u<adlist.length;u++){
            for(int v : adlist[u]){
                indegree[v]++;  // if x is nbr of y then a directed edge exists from y -> x
            }
        }

        // 3. put node's with 0 indegree to queue
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        // 4. start bfs
        while (!queue.isEmpty()){
            int node = queue.poll();

            // do task (print/process/execute)
            System.out.print(node + " -> ");

            for(int neighbour : adlist[node]){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0 ) {
                    queue.add(neighbour);
                }

            }
        }




    }
    public static void main(String[] args) {
        int  N = 7; // nodes
        int[][] graph = {
                {0,1},
                {0,2},
                {1,3},
                {1,4},
                {2,3},
                {2,5},
                {3,4},
                {3,5},
                {4,5},
                {6,1},
                {6,4}
        };
        topologicalSort(N,graph);

    }
}
