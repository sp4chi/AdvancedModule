package Searching;

public class CountElementOccurrence {
    public static int findCount(final int[] A, int B) {
        int cnt = 0;
        int low = 0;
        int high = A.length - 1;

        // finding first occurrence of target
        int firstOcc = -1;
        while(low <= high){
            int mid = (high - low)/2 + low;

            if(A[mid] == B){
                firstOcc = mid;
                high = mid - 1;
            }else if(A[mid] < B){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        if(firstOcc == -1) return 0; // if target absent in array


        // finding last occurrence of target
        low = 0;
        high = A.length - 1;
        int lastOcc = -1;
        while(low <= high){
            int mid = (high - low)/2 + low;

            if(A[mid] == B){
                lastOcc = mid;
                low = mid + 1;
            }else if(A[mid] < B){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return lastOcc - firstOcc + 1;
    }

    public static void main(String[] args) {
        int[] A={-5,-5,-5,0,0,0,1,2,2,2,7,7};
        System.out.println(findCount(A,0));
    }
}



