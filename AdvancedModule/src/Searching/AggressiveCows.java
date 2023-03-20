package Searching;

import java.util.Arrays;

public class AggressiveCows {
    //given an array containing position of stalls and C as the number of cows to place, find the maximum of minimum separation between cows.
    public static int binarySearch(int[] stalls,int C){
        int N=stalls.length;
        Arrays.sort(stalls);
        int start = 0;
        int end = stalls[N-1]-stalls[0];
        int current_ans = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(canPlaceStalls(stalls,mid,C)){
                current_ans = mid;
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return current_ans;
    }
    public static boolean canPlaceStalls(int[] stalls, int mid, int C){
        int cows=1;
        int lastCowX = stalls[0];
        int N=stalls.length;
        for(int i=1;i<N;i++){
            if(stalls[i] - lastCowX >= mid){
                cows++;
                lastCowX = stalls[i];
                if(cows == C){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] stalls = {1,2,4,8,9};
        System.out.println("Max of min separation of cows:"+binarySearch(stalls,3));
    }
}
