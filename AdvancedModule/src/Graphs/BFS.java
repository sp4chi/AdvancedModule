package Graphs;

import java.util.*;

public class BFS {
    public static void bfs(int startNode, ArrayList<Integer>[] adList, boolean[] visited){
        //1. Initialize - create queue
        Queue<Integer> queue = new LinkedList<>();

        //2.1 mark start node as visited
        visited[startNode] = true;

        //2.2 Process node
        System.out.println(startNode);

        //2.3 Push start node to queue
        queue.add(startNode);

        //3. while queue is not empty, pop a node, repeat 2 for its neighbours
        while (!queue.isEmpty()){

            //3.1 pop node
            int node = queue.poll();

            //3.2 traverse neighbour list
            for(int neighbour : adList[node]){

                if(!visited[neighbour]){

                    //3.3 Mark neighbour as visited
                    visited[neighbour] = true;

                    //3.4 Process node
                    System.out.println(neighbour);

                    //3.5 Push neighbour to queue
                    queue.add(neighbour);
                }

            }
        }

        //chatgpt - https://chatgpt.com/share/69615947-5364-800a-9cff-b0d06fcea8b7
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
        /*for(boolean b : visited){
            System.out.print(b+" ,");
        }*/

        int startNode = 0;
        bfs(0,adList,visited);

        //for disconnected graph
        /*for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                bfs(i, adList, visited);
            }
        }*/

    }
}
