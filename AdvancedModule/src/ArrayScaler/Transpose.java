package ArrayScaler;

public class Transpose {
    public static int[][] transpose(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int[][] B = new int[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++) B[i][j] = A[j][i];

        return B;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1,2},
                {3,4},
                {5,6}
        };
        int[][] B = transpose(A);
        for (int[] ints : B) {
            for (int j = 0; j < B[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }

    }
}
