package Heaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;


public class TopKElements {
    public static List<Integer> getTopKElements(int[] nums, int k) {
        // Create a min-heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for(Integer el : nums){
            map.putIfAbsent(el,map.getOrDefault(el,0)+1);
        }

        System.out.println(map);

        for (int num : map.keySet()) {
            minHeap.add(map.get(num));
            // If the heap exceeds size k, discard the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        int[] elements = {1,2,1,2,1,2,3,1,3,2};
        int k = 2;
        System.out.println(getTopKElements(elements,k));
    }
}


