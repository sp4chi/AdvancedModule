package Heaps;

public class KthLargestElement {
    public static void printKthLargestElement(int k, int[] arr){
        //brute
        int N = arr.length;

        //1. initialise the prevLargest and currentLargest, we need them for finding
        // largest and next largest elements
        int prevLargest = Integer.MAX_VALUE;
        int currentLargest = Integer.MIN_VALUE;

        //2. using 2 nested loops, one will run k times for kth largest and another will
        // run n times for searching
        for(int i=0; i<k ; i++){

            //2.1 currentLargest should start from min value for finding largest
            currentLargest = Integer.MIN_VALUE;

            //2.2 search largest
            for(int j=0;j<N;j++){

                //2.2.1 ensures we only consider elements smaller than the previous largest
                if(arr[j] < prevLargest && arr[j] > currentLargest) {

                    //2.2.2 update currentLargest
                    currentLargest = arr[j];

                }
            }
            //2.3 update prevLargest so that we can find second-largest element in the next iteration
            prevLargest = currentLargest;
        }
        //3. print or return value
        System.out.println(currentLargest);
        // IMPORTANT - the logic and when to update
        //TC - k x n ; SC - O(1)
    }

    // Second - sort and find the largest kth element. TC - n x log n, SC - O(1)
    // Third - insert in max heap, remove top element k times. Removing - k-1 elements,
    // heapify - log n . The top element in heap is our ans. So TC -  k log n.

    // Important if k->n then TC -> n log n, in such a case use min heap.
    // Remove n-k element. The top element in our heap is our ans. TC - (n - k) log n
    // chatgpt discussion - https://chatgpt.com/share/6954fd6f-0adc-800a-8e87-b57fa7b5331f

    public static void main(String[] args) {

        int[] arr = {22,1,44,-1,10,8,9}; //ans = 10
        int k = 3;
        printKthLargestElement(k,arr) ;
    }
}
