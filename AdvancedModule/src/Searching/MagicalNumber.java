package Searching;

import LCM.LCM;

public class MagicalNumber {
    //Find out Ath magical number (from the set of natural no's). A magical number is such that it is divisible by both A and B. Ex -  A = 8, B = 2, C = 3. Now, numbers divisible by 2 or 3 are - 2,3,4,6,8,9,10,12,14,... but 8th number is 12 so answer is 12.
    public static int binarySearch(int A, int B, int C){
        int start = Math.min(B,C);
        int end = A*Math.min(B,C);
        int lcm = LCM.lcm(B,C);
        int ans = start ;
        while(start<=end){
           int mid = start + (end-start)/2;
           int cnt = countLeftOfMid(mid,B,C,lcm);
           if(cnt == A){
               ans = mid;
               end = mid - 1;
           } else if (cnt < A) {
               start = mid + 1;
           } else {
               end = mid - 1;
           }
        }
        return ans;
    }
    public static int countLeftOfMid(int mid, int B, int C, int lcm){
        return mid/B + mid/C - mid/lcm;
    }

    public static void main(String[] args) {
        int A = 8;
        int B = 2;
        int C = 3;
        System.out.println(binarySearch(A,B,C));
    }
}
