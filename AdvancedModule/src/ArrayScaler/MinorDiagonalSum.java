package ArrayScaler;

public class MinorDiagonalSum {
    /*You are given a N X N integer matrix. You have to find the sum of all the minor diagonal elements of A.

    Minor diagonal of a M X M matrix A is a collection of elements A[i, j] such that i + j = M + 1 (where i, j are 1-based).*/
    public static int solve(final int[][] A) {
        int N=A.length;
        int i=0;
        int j=N-1;
        int sum = 0;
        while(i<N && j>=0){
            sum+=A[i++][j--];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] A={{1, -2, -3},{-4, 5, -6},{-7, -8, 9}};
        System.out.println(solve(A));
    }
}
