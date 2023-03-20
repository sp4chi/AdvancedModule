package Searching;

public class GreatestInteger {
    public static int greatestInteger(int[] A, int target){
        return greatestInteger(A,0,A.length-1,target);
    }
    //Given a sorted array of integers, find the greatest element <= Target in the array.
    public static int greatestInteger(int[] A, int start, int end, int target){
        int greatestInt= Integer.MIN_VALUE ;//smallest number not possible to appear in the input array
        //int greatestIndex=0;
        if(start>end)
            return -1;
        while(start<=end){
            int mid= start + (end-start)/2;

            if(A[mid] == target){
                return A[mid];
            }else if (target<A[mid]) {
                end = mid-1;
            } else{
                greatestInt = A[mid];
                start = mid+1;
            }
        }
        return greatestInt;
    }
    public static void main(String[] args) {
        int[] A= {2,11,15,18,23,37,49,51,57,67};
        int index=greatestInteger(A,17);
        if(index==-1){
            System.out.println("Element not found");
        }else{
            System.out.println("Greatest integer "+index+" found.");
        }

    }
}
