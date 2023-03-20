package Searching;

public class BinarySearch {
    public static int binarySearch(int[] A,int target){
        return binarySearch(A,0,A.length-1,target);
    }
    public static int binarySearch(int[] A, int start, int end,int target){

        while(start<=end){
            int mid= start + (end-start)/2;

            if (target == A[mid]) {
                return mid;
            }else if(target<A[mid]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }

    //using recursion here
    /*public static int binarySearch(int[] A, int start, int end,int target){
        if(start>end)
            return -1;
        int mid=start + (end-start)/2;

        if (target == A[mid]) {
            return mid;
        }else if(target<A[mid]){
            return binarySearch(A,start,mid-1,target);
        }else{
            return binarySearch(A,mid+1,end,target);
        }
    }*/

    public static void main(String[] args) {
        int[] A= {2,11,15,18,23,37,49,51,57,67};
        int index=binarySearch(A,19);
        if(index==-1){
            System.out.println("Element not found");
        }else{
            System.out.println("Element "+A[index] + " found at position "+index);
        }

    }
}
