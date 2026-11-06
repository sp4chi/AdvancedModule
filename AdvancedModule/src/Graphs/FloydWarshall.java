package Graphs;

import java.util.ArrayList;

public class FloydWarshall {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();

        // Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (A.get(i).get(k) != -1 && A.get(k).get(j) != -1) {
                        int newDist = A.get(i).get(k) + A.get(k).get(j);
                        if (A.get(i).get(j) == -1 || newDist < A.get(i).get(j)) {
                            A.get(i).set(j, newDist);
                        }
                    }
                }
            }
        }

        return A;
    }
}


