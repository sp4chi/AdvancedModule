package Hashing;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    //Given an unsorted integer array A of size N.
    //Find the length of the longest set of consecutive elements from array A.
    public static int findingLongestSubsequence(int[] A){
        int maxSubsequence=0;
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
        int[] A={100,4,200,1,3,2};
        System.out.println(findingLongestSubsequence(A));
    }
}
