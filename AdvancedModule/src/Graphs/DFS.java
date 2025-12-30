package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class DFS {
    public static void dfs(int node, boolean[] visited, ArrayList<Integer>[] adList){
        //1. if node visited return
        if(visited[node]){
            return;
        }

        //2. else mark it as true
        visited[node] = true;
        //3. process it -> print the node
        System.out.println("visited node: "+node);


        //4. extract list from the array
        ArrayList<Integer> list = adList[node];

        //5. dfs on its neighbours
        for(int neighbour : list){

            //5.1 optional check to avoid unnecessary function calls
            if(!visited[neighbour]) {
                dfs(neighbour, visited, adList);
            }
        }
        /*
         * checking type of adList[node], ** debugging ignore **
         * System.out.println(list.getClass().getName());
         */
    }
    public static void main(String[] args) {

        //declaring the adjacency list
        ArrayList<Integer>[] adList = new ArrayList[12];

        //initialize each adjacency array with list ** mandatory **
        for(int i=0;i<adList.length;i++){
            adList[i] = new ArrayList<>();
        }

        //filling the adjacency list manually
        adList[0].add(1);
        adList[0].add(9);

        adList[1].add(0);
        adList[1].add(8);

        adList[2].add(3);

        adList[3].add(2);
        adList[3].add(4);
        adList[3].add(5);
        adList[3].add(7);

        adList[4].add(3);

        adList[5].add(3);
        adList[5].add(6);

        adList[6].add(5);
        adList[6].add(7);

        adList[7].add(3);
        adList[7].add(6);
        adList[7].add(8);
        adList[7].add(10);
        adList[7].add(11);

        adList[8].add(1);
        adList[8].add(7);
        adList[8].add(9);

        adList[9].add(0);
        adList[9].add(8);

        int N = adList.length;
        boolean[] visited = new boolean[N];
        Arrays.fill(visited, false);
        for(boolean b : visited){
            System.out.print(b+" ,");
        }

        int startNode = 0;
        dfs(startNode,visited,adList);
    }
}
