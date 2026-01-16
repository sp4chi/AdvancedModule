package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FindPathInDirectedGraph {
    //given no. of nodes A and 2d matrix M x 2 rep. directed edges
    //to find whether path exists btw 1 - A
    //approach - 1. can we use this edge list matrix directly ?
    //approach - 2. build directed adjacency list from given 2d matrix,
    //use dfs, if dfs returns 1 path exist, else no path exist
    public static int solve(int A, int[][] B) {
        int N = A;
        boolean[] visited = new boolean[N+1];
        Arrays.fill(visited, false);

        // build ad List
        ArrayList<Integer>[] adList = new ArrayList[N+1];
        for(int i = 1 ;i <= N; i++){
            adList[i] = new ArrayList<>();
        }

        for(int[] e : B){
            adList[e[0]].add(e[1]);

            // if undirected
            // adList[e[1]].add(e[0]);
        }

        //dfs(1,adList,visited);  //using dfs
        bfs(1,adList,visited);   //using bfs
        // check if A was visited or not
        if(visited[A]) return 1;

        return 0;

        // call dfs on all nodes
        // for(int node : adList){
        //     if(!visited[node]){
        //         dfs(node,adList,visited);
        //     }
        // }

    }

    public static void dfs(int node, ArrayList<Integer>[] adList, boolean[] visited){
        if(visited[node]){
            return;
        }

        visited[node] = true;

        ArrayList<Integer> neighbours = adList[node];

        for(int neighbour : neighbours){

            if(!visited[neighbour]){
                dfs(neighbour,adList,visited);
            }
        }
    }

    public static void bfs(int startNode, ArrayList<Integer>[] adList, boolean[] visited){
        visited[startNode] = true;

        Queue<Integer> queue = new LinkedList<>();

        queue.add(startNode);

        while (!queue.isEmpty()){
            int node = queue.poll();

            for(int neighbour : adList[node]){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
    }
    public static void main(String[] args) {
        int A = 5;
        int[][] B = {
                {1,2},
                {4,1},
                {2,4},
                {3,4},
                {5,2},
                {1,3}
        };// no path exist
        /*int A = 4;
        int[][] B = {
                {1,2},
                {2,3},
                {3,4},
        };//path exists*/

        System.out.println(solve(A,B) == 1? "Path Exist" : "No path exists");
    }
}
