package Hashing;

import java.util.HashMap;

public class MinDistanceBtwDuplicates {
    //given an array of integers of size N, find min distance between duplicates
    //Brute Force
    //time - O(N*N)
    //space - O(1)
    public static int minDistanceBrute(int[] A){
        int N = A.length;
        int min = N;
        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                if(A[i]==A[j]){
                    min=Math.min(min,j-i+1);
                }
            }
        }
        return min;
    }
    //Hashing Approach
    //time - O(N)
    //space - O(N)
    public static int minDistanceUsingHashing(int[] A){
        int N = A.length;
        int min = N;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            if(map.containsKey(A[i])){
                min=Math.min(min,i-map.get(A[i]));
            }
            map.put(A[i],i);
        }
        if(min!=N) //if no duplicates present
            return min;

        return -1;
    }
    public static void main(String[] args) {
        int[] A={1,2,3,4,1,2,3,1};
        System.out.println(minDistanceUsingHashing(A));
    }
}
