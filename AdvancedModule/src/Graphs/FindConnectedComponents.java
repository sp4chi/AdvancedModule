package Graphs;

import java.util.ArrayList;

public class FindConnectedComponents {
    public static void findConnectedComponents(int N, boolean[] visited, ArrayList<Integer>[] adj){

        int count = 0;

        //1. traverse the adjacency list
        for(int i=0;i<N;i++){

            //2. if node not visited
            if(!visited[i]){

                //3. call dfs to traverse the component
                DFS.dfs(i,visited,adj);

                //4. increment count
                count++;

            }
        }

        //5. process the value - print in our case
        System.out.println("Connected components are : "+count);
    }
    public static void main(String[] args) {
        ArrayList<Integer>[] adj = new ArrayList[8];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        // Component 1: 0 - 1 - 2
                adj[0].add(1);
                adj[1].add(0);

                adj[1].add(2);
                adj[2].add(1);

        // Component 2: 3 - 4
                adj[3].add(4);
                adj[4].add(3);

        // Component 3: 5 - 6
                adj[5].add(6);
                adj[6].add(5);

        // Component 4: 7 (isolated)

        for (ArrayList<Integer> x : adj) {
            System.out.println(x);
        }

        int N = adj.length;
        boolean[] visited = new boolean[N];
        findConnectedComponents(N,visited,adj);
    }
}
