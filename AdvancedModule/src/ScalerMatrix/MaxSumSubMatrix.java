package ScalerMatrix;

public class MaxSumSubMatrix {
    //Given a 2D integer matrix A of size N x N, find a B x B sub-matrix where B<= N and B>= 1, such that the sum of all the elements in the sub-matrix is maximum.
    public static void maxSubMatrix(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int[] pf = new int[M];
        int k=0;

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += A[i][j];
            }
            pf[k++] = sum;
        }

        for(int y1=0;y1<M-1;y1++){
            for(int y2=y1;y2<M;y2++){
                
            }
        }

    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 8, 6, 7, 3},
                {4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5}
        };
        maxSubMatrix(A);
        //System.out.println(maxSubMatrix(A));
    }
}
