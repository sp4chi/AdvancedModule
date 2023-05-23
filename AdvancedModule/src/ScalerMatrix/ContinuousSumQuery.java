package ScalerMatrix;

public class ContinuousSumQuery {
    public static int[] query(int A, int[][] B) {
        int[] result = new int[A];
        int row = B.length;
        if(row == 0 ) return result;
        int col = B[0].length;

        for (int j = 0; j < row; j++) {
            int L = B[j][0];
            int R = B[j][col - 2];
            int P = B[j][col - 1];
            for (int k = L; k <= R; k++) {
                result[k-1] += P;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1,2,10},
                {2,3,20},
                {2,5,25}
        };
        int[] B = query(5, A);
        for (int i : B) {
            System.out.print(i + " ");
        }

    }
}
