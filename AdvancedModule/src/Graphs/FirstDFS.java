package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class FirstDFS {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int solve(int[] A, final int B, final int C) {
        //if C's index is less than B's then, B is reachable from class
        // approach 1 - traverse the array and store B and C's idx, compare
        // and return
        // int N = A.length;
        // int b = Integer.MIN_VALUE;
        // int c = Integer.MAX_VALUE;

        // for(int i=0; i<N ; i++){
        //     if(A[i] == C){
        //         c = i;
        //     }

        //     if(A[i] == B){
        //         b = i;
        //     }
        // }

        // return (c < b) ? 1 : 0;

        // approch 2 - if B is reachable from C, C has to be parent of B or
        // B has to be in the subtree of c
        // algo - find all c's and check child if B, else put in queue,
        // bfs the queue till you find B or nah!

        //edge case
        /*if (B == C) return 1;
        int N = A.length;
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();

        // 1. traverse the array
        for(int i=1; i<N; i++){

            // 1.1 find C
            if(A[i] == C){
                int child = i+1;

                // 1.2 check child is B or not,
                // yes return, no mark as visited,
                // put idx not child in queue ** gotcha **
                if(child == B) return 1;

                visited[i] = true;
                queue.add(i);
            }
        }

        // 2. while queue not empty, pop and check if child B,
        // not B put child in queue, repeat
        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int i=1; i<N ; i++){
                if(!visited[i] && A[i] == node){

                    int child = i + 1;

                    if(child == B) return 1;

                    visited[child] = true;
                    queue.add(child);
                }
            }
        }

        return 0;*/

        // Edge case: same town
        if (B == C) return 1;

        int N = A.length;

        // visited[x] = whether town x has been visited
        boolean[] visited = new boolean[N + 1];

        Queue<Integer> queue = new LinkedList<>();

        // Start BFS from C
        queue.add(C);
        visited[C] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            // Scan array to find children of `node`
            for (int i = 1; i < N; i++) {
                if (A[i] == node) {
                    int child = i + 1;

                    if (child == B) return 1;

                    if (!visited[child]) {
                        visited[child] = true;
                        queue.add(child);
                    }
                }
            }
        }

        return 0;


    }

    public static void main(String[] args) {
        //int[] A = {1,1,1,3,3,2,2,7,6};
        int[] A = {1,1,2,3,4};
        int B = 2;
        int C = 4;
        System.out.println(solve(A,B,C));
    }
}


