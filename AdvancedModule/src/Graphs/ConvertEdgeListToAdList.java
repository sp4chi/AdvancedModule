package Graphs;

import java.util.ArrayList;

public class ConvertEdgeListToAdList {
    public static void convert(int A, int[][] B) {
        // 1. convert edge lost to adjacency list
        ArrayList<Integer>[] adlist = new ArrayList[A];
        for(int i=0;i<A;i++){
            adlist[i] = new ArrayList<>();
        }

        for (int[] ints : B) {
            int u = ints[0];
            int v = ints[1];

            adlist[u].add(v);
            adlist[v].add(u);  // if directed comment this line
        }

        // * optional * (printing)
        for(int i=0;i<A;i++){
            System.out.println(adlist[i].toString());
        }
    }
    public static void main(String[] args) {
        int A = 5; //nodes
        int[][] B = {
                {0,1},
                {3,0},
                {1,3},
                {2,3},
                {4,1},
                {0,2}
        }; // B[i][0] - B[i][1] edge

        convert(A,B);
    }
}
