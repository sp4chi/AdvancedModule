package TwoPointer;

import java.util.Arrays;

public class TwoSumEasy {
    //Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
    //
    //If the answer does not exist return an array with a single element "-1".
    //
    //First sub-array means the sub-array for which starting index in minimum
    public static int[] twoPointer(int[] A, int B) {
        int N = A.length;
        int start = 0;
        int end = 0;
        int sum = A[start];
        while(end<N && start<=end){
            if(sum == B){
                return Arrays.copyOfRange(A, start, end+1);
            }
            else if(sum < B){
                end++;
                if(end < N){
                    sum+=A[end];
                }
            } else{
                sum-=A[start];
                start++;
                if(start>end){
                    end++;
                    if(end<N) {
                        sum+=A[end];
                    }
                }
            }
        }
        return new int[]{-1};
    }

    public static void main(String[] args) {
        int[] A={15, 2, 5, 6, 9,11,8, 10 };
        int B = 13;
        int[] ans=twoPointer(A,B);
        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}
