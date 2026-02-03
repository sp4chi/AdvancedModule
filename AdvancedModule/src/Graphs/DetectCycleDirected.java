package Graphs;

import java.util.ArrayList;

public class DetectCycleDirected {
    public static int dfs(int N, ArrayList<Integer>[] adlist){
        boolean[] visited = new boolean[N+1];
        boolean[] inStack = new boolean[N+1];


        for(int i=1;i<=N;i++){
            if(!visited[i]) {
                if (dfshelper(i, adlist, visited, inStack)) {
                    return 1;
                }
            }
        }
        return 0;

    }

    public static boolean dfshelper(int node, ArrayList<Integer>[] adlist,
                             boolean[] visited,
                             boolean[] inStack){


        // 1. mark node as visited and add to stack
        visited[node] = true;
        inStack[node] = true;


        // 2. dfs on neighbours
        for(int neighbour : adlist[node]){
            if(!visited[neighbour]){  // neighbour not visited -> dfs on it
                 if(dfshelper(neighbour,adlist,visited,inStack)){
                     return true;
                 }
            }else if(inStack[neighbour]){  // neighbour visited and in stack, *** cycle ***
                return true;               // back-edge found
            }
        }
        inStack[node] = false;  // remove from stack
        return false;
    }
    public static void main(String[] args) {
        int N = 6;
        ArrayList<Integer>[] adlist = new ArrayList[N+1];

        for(int i=1;i<=N;i++){
            adlist[i] = new ArrayList<>();
        }

        adlist[1].add(2);
        adlist[1].add(6);

        adlist[2].add(4);

        adlist[3].add(2);

        adlist[4].add(5);
        adlist[4].add(5);

        adlist[5].add(3);


        if(dfs(N,adlist) == 1){
            System.out.println("Cycle detected");
        }else{
            System.out.println("No Cycle");
        }



    }
}
