package Heaps;

import java.util.PriorityQueue;

public class MinimumCostOfMergingRopes {

    //Q. Given lengths of N ropes, the cost of merging two ropes is equal to
    // the sum of their lengths. Find min cost to merger all the ropes in a single rope
    // Ex -  ropes = [1,4,2,5], ans = 22. Why?


    // Intuition - Merging small ropes first minimizes how many times large ropes gets added to
    // the total cost
    // Algo - add input to min heap, extract two nodes, merge them and add to heap again
    // min heap ensures smallest elements are merged first and inserting the merged value to
    // heap ensures the merge process is complete, otherwise polling will return the same value
    // merges - ( N - 1 )
    // TC - adding to heap (N log N) + merging ( N-1 log N ) =  N log N
    // SC - N
    // if added using build heap function ( PQ<>(ArrayList<>() list), tc of adding to heap = n

    public static void findMinCost(int[] ropes){

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x : ropes){
            pq.add(x);
        }

        int cost = 0;

        // loop n - 1 times because for n ropes there are only n-1 merges possible
        while(pq.size()>1){

            // poll two ropes and calculate sum, this does our merge operation
            int sum = pq.poll() + pq.poll() ;

            //calculate cost
            cost = cost + sum;

            // add it heap again, completes the merge operation
            pq.add(sum);
        }
        System.out.println(cost);
    }
    public static void main(String[] args) {
        int[] ropes = {1,4,2,5};
        findMinCost(ropes);
    }
}
