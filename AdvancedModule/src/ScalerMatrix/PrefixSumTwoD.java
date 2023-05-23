package ScalerMatrix;

public class PrefixSumTwoD {
    public static int[][] buildPf(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] pf = new int[row][col];
        pf[0][0] = A[0][0];
        for (int i = 1; i < col; i++) {
            pf[0][i] = pf[0][i - 1] + A[0][i];
        }
        for (int i = 1; i < row; i++) {
            pf[i][0] = pf[i - 1][0] + A[i][0];
        }

        for (int i = 1; i < col; i++) {
            for (int j = 1; j < row; j++) {
                pf[i][j] = pf[i - 1][j] + pf[i][j - 1] - pf[i - 1][j - 1] + A[i][j];
            }
        }
        return pf;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 1},
                {1, 1}
        };
        int[][] B = buildPf(A);
        int row = B.length;
        int col = B[0].length;
        for(int i=0;i<col;i++){
            for(int j=0;j<row;j++){
                System.out.print(B[i][j]+" ");
            }
            System.out.println();
        }
    }
}
