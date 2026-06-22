package Searching;

public class SquareRoot {
    public static int sqrt(int A) {
        int low = 0;
        int high = A;
        int ans = 0;
        while(low <= high){
            int mid = (high - low)/2 + low;

            if((long)mid*mid <= A){  // typecasting to long to prevent overflow
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int A = 11;
        System.out.println(sqrt(A));
    }
}



