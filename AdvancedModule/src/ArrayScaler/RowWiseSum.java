package ArrayScaler;

public class RowWiseSum {
    public static int[] rowWise(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int[] B=new int[N];

        for(int i = 0 ; i < N ; i++ ){
            int sum = 0;
            for(int j = 0 ; j < M ; j++ ){
                sum += A[i][j];
            }
            B[i] = sum;
        }
        return B;
    }

    public static void main(String[] args) {
        int[][] A={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        int[] B = rowWise(A);
        for(int i: B){
            System.out.print(i+" ");
        }
    }
}
