package Hashing;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    //Brute Force
    public static int findingLongestBrute(int[] A){
        int N = A.length;
        int max = 0;
        //loop to traverse the array
        for (int value : A) {
            int temp = value - 1;
            int k = 0;
            for (int j = 0; j < N; j++) {
                if (linearSearch(A, temp) != -1) {
                    k++;
                    temp++;
                }
            }
            max = Math.max(max, k);
        }
        return max;
    }
    public static int linearSearch(int[] A, int target){
        int N = A.length;
        for(int i=0;i<N;i++){
            if(A[i]==target){
                return i;
            }
        }
        return -1;
    }
    //Given an unsorted integer array A of size N.
    //Find the length of the longest set of consecutive elements from array A.
    public static int findingLongestSubsequence(int[] A){
        int maxSubsequence = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i:A){
            set.add(i);
        }
        for(int i:set){
            int startOfSubsequence=i;
            if(!set.contains(startOfSubsequence-1)){
                int count = 1;
                while(set.contains(startOfSubsequence+1)){
                    count++;
                    startOfSubsequence++;
                }
                maxSubsequence = Math.max(maxSubsequence, count);
            }
        }
        return maxSubsequence;
    }

    public static void main(String[] args) {
        //int[] A={100,4,200,1,3,2};
        //int[] A={2,1,4};
        int[] A={11,21,13,14,15,12,10,2, 1};
        System.out.println(findingLongestBrute(A));
    }
}
