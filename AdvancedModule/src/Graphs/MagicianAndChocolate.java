package Graphs;

import java.util.Collections;
import java.util.PriorityQueue;

public class MagicianAndChocolate {
    public static int nchoc(int A, int[] B) {

        // intuition - adding max elements first maximizes our value

        int mod = 1_000_000_007;
        // create max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // add elements to heap, n log n, O(n) if using buildheap
        for (int x : B) {
            pq.add(x);
        }

        long totalMax = 0;
        while (A > 0) {

            long currentMax = pq.poll();

            totalMax = (totalMax + currentMax) % mod;


            int magic = (int) Math.floor(currentMax / 2);

            pq.add(magic);

            A--;
        }
        return (int) totalMax;
    }

    public static void main(String[] args) {
        int[] chocolates = {2, 4, 6, 8, 10};
        int A = 5;
        System.out.println(nchoc(A, chocolates));
    }
/*
    t1, eaten = 10, [2,4,6,8,5]
    t2, eaten = 18, [2,4,6,4,5]
    t3, eaten = 24, [2,4,3,4,5]
    t4, eaten = 29, [2,4,3,4,2]
    t5, eaten = 33, [2,4,3,2,2]
*/
}
