package Searching;

public class MedianOfSortedMatrix {
    public static int findMedian(int[][] A) {
        int M = A.length;
        int N = A[0].length;

        int rank = (1 + M * N)/2;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int[] ints : A) {
            low = Math.min(low, ints[0]);
            high = Math.max(high, ints[N - 1]);
        }


        int ans = 0;

        while(low <= high){
            int mid = (low + high)/2;

            int cnt = 0;

            // upperbound
            for(int row = 0; row < M; row++){
                int lowU = 0;
                int highU = N - 1;

                int ansU = N;

                while (lowU <= highU){
                    int midU = (lowU + highU)/2;

                    if(A[row][midU] > mid){
                        ansU = midU;
                        highU = midU - 1;
                    }else {
                        lowU = midU + 1;
                    }
                }

                cnt += ansU;

            }

            if(cnt >= rank){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1,3,5},
                {2,6,9},
                {3,6,9}
        };

//        int[][] A={
//                {1,2,5},
//                {2,3,4},
//                {4,4,5}
//        };

        System.out.println(findMedian(A));
    }
}





