package Searching;

public class PaintersPartition2 {
    public static boolean validWork(int A, int B, int[] C, long mid){
        long work = 0;
        int paintersUsed = 1;
        for(int i : C){
            work += i;

            if(work > mid ){
                paintersUsed++; // new painter used
                work = i; // he is assigned the current work
                if(paintersUsed > A) return false; // we return false when painters used is more than A
            }
        }

        return true;
    }
    public static  int paint(int A, int B, int[] C) {
        // painting 1 unit takes B units o time by each painter
        // painting C units takes C * B units of time by each painter
        // suppose 4 painters and 4 boards are there, then minimum time to complete painting
        // all of the boards is max(boards) * B. Cannot be faster than this
        // if one painter and 4 boards present then max time to complete is sum(boards) * B.

        int mod = 10_000_003;
        long low = 0;
        for(int i : C){
            low = Math.max(i,low);
        }

        long high = 0;
        for(int i : C){
            high += i;
        }

        // our ans lies btw low and high. Why ? these low and high are extreme conditions.
        // other cases lie in between them like 2 painters 3 boards. Lower bound is when
        // painters equal the no. of boards and higher bound is when only one painter is
        // there and boards are 1 or more. Rest cases lie in between. We can binary search
        // on work load (time to complete 1 unit of the board (B) * total units in a board (C))
        // the mid we get is the max work we *can* assign to a painter such that total time to
        // complete the work is minimized. If we can assign then we go left with the hope
        // of finding a better time. Else we go right.
        // How do we check if a current mid is valid/assigable.
        // keep allocating boards to a painter until his work is less than or equal to
        // mid. Assign to board to next painter once work is greater than mid. Keep doing it until
        // you run out of board. Keep track of painters used count. If it is <= to A
        // it is valid else not.

        long ans = high;
        while(low <= high){
            long mid = (high - low)/2 + low;

            if(validWork(A,B,C,mid )){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        long temp = (ans*B) % mod;
        return (int)temp;
    }

    public static void main(String[] args) {
        int A = 1;
        int B =  1000000;
        int[] C = { 1000000, 1000000};
        System.out.println(paint(A,B,C));
    }
}



