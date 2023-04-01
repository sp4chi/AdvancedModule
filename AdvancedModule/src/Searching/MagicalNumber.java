package Searching;

import LCM.LCM;

public class MagicalNumber {
    static int mod = 1000000007;
    //Find out Ath magical number (from the set of natural no's). A magical number is such that it is divisible by both A and B. Ex -  A = 8, B = 2, C = 3. Now, numbers divisible by 2 or 3 are - 2,3,4,6,8,9,10,12,14,... but 8th number is 12 so answer is 12.
    public static int binarySearch(int A, int B, int C){
        long start = Math.min(B,C);
        long end = A * start;
        long lcm = LCM.lcm(B,C);
        long mod = (long)Math.pow(10, 9) + 7;
        long ans = start ;
        while(start<=end){
           long mid = start + (end - start)/2;
           long cnt = countLeftOfMid(mid,B,C,lcm);
           if(cnt == A){
               ans = mid;
               end = mid - 1;
           } else if (cnt < A) {
               start = mid + 1;
           } else {
               end = mid - 1;
           }
        }
        return (int)(ans%mod);
    }
    public static long countLeftOfMid(long mid, int B, int C, long lcm){
        return mid/B + mid/C - mid/lcm;
    }

    public static void main(String[] args) {
        int A = 807414236;
        int B = 3788;
        int C = 38141;
        System.out.println(binarySearch(A,B,C));
    }
}
