package Searching;

public class Frequency {
    public static int frequency(int[] A, int target){
        return frequency(A,0,A.length-1,target);
    }
    //Given an array and target, find frequency of target element
    public static int frequency(int[] A, int start, int end, int target){
       if(start>=end){
           return -1;
       }
       int freq=0;
       while(start<=end){
           int mid = start + (end-start)/2;
           if(A[mid]==target) {
               int fwd=mid;
               while(fwd<=end && A[fwd]==target){
                   freq++;
                   fwd++;
               }
               int bkd=mid-1;
               while(bkd>=start && A[bkd]==target ){
                   freq++;
                   bkd--;
               }
               return freq;
           }else if(A[mid]<target){
               start=mid+1;
           } else{
               end = mid-1;
           }
       }
       return freq;
    }

    public static void main(String[] args) {
        int[] A={-5,-5,-5,0,0,0,1,2,2,2,7,7};
        System.out.println(frequency(A,0));

    }
}
