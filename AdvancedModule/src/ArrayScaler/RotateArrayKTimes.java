package ArrayScaler;

import java.util.Arrays;

public class RotateArrayKTimes {

        public static void rotate(int[] arr, int start, int end){
            int N = arr.length;
            int left = start;
            int right = end;
            while(left<right){
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;

                left++;
                right--;
            }
        }
        public static int[] solve(int[] A, int B) {
            int N = A.length;
            rotate(A,0,N-1);
            rotate(A,0,B%N-1);
            rotate(A,B%N,N-1);
            return A;
        }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        int B = 11;
        System.out.println(Arrays.toString(solve(A, B)));
    }


}
