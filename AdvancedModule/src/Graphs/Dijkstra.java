package Graphs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node {
    int data, weight;

    Node(int data, int weight) {
        this.data = data;
        this.weight = weight;
    }
}
public class Dijkstra {
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B, int C) {
        ArrayList<Node>[] graph = new ArrayList[A];

        // Add ArrayList object to each index
        for(int i = 0; i < A; i++) {
            graph[i] = new ArrayList<>();
        }

        // Create the graph from given data
        for(int i = 0; i < B.size(); i++) {
            int from = B.get(i).get(0);
            int to = B.get(i).get(1);
            int weight = B.get(i).get(2);
            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }

        // Declare the ans array
        int[] ans = new int[A];
        Arrays.fill(ans, Integer.MAX_VALUE); // Initialize distances with max MAX_VALUE

        // Create a min heap to perform operations for Dijkstra's algorithm
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        minHeap.add(new Node(C, 0));

        // Perform Dijkstra's algorithm
        while(!minHeap.isEmpty()) {
            Node curr = minHeap.poll();

            // Skip if the node is already processed
            if(curr.weight > ans[curr.data])
                continue;

            ans[curr.data] = curr.weight; // Update distance

            // Update distances of adjacent nodes
            for(Node neighbor : graph[curr.data]) {
                int newWeight = curr.weight + neighbor.weight;
                if(newWeight < ans[neighbor.data]) {
                    ans[neighbor.data] = newWeight;
                    minHeap.add(new Node(neighbor.data, newWeight));
                }
            }
        }

        // Convert the array to ArrayList and return the result
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < A; i++) {
            if(ans[i] == Integer.MAX_VALUE) {
                result.add(-1);
            } else {
                result.add(ans[i]);
            }
        }

        return result;
    }
}



