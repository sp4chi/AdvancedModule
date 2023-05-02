package QueueScaler;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxElementInWindow {
    public static String maxInWindow(int[] A,int k){
        int N = A.length;
        int[] output = new int[N-k+1];
        Deque<Integer> dq = new LinkedList<>();

        //building deque for first window
        for(int i=0;i<k;i++){
            int temp = A[i];
            while (!dq.isEmpty() && A[dq.peekLast()]<temp){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        int x=0;
        //building deque for rest windows
        for(int i=k;i<N;i++){
            if(!dq.isEmpty()) output[x++] = A[dq.peekFirst()];
            int temp = A[i];
            //removing smaller elements than current
            while (!dq.isEmpty() && A[dq.peekLast()]<temp) dq.removeLast();
            //removing elements not in the window
            while (!dq.isEmpty() && dq.peekFirst()<=i-k) dq.removeFirst();

            dq.addLast(i);
        }
        if(!dq.isEmpty()) output[x] = A[dq.peekFirst()];
        return Arrays.toString(output);
    }

    public static void main(String[] args) {
        int[] A={10,1,8,9,7,6,5,11,3};
        int window = 3;
        System.out.println(maxInWindow(A,window));
    }
}
