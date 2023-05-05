package ArrayScaler;

public class Diagonals {
    public static void diagonals(int[][] A) {
        int N = A.length;
        //loop for top triangle
        for (int i = 0; i < N; i++) {
            int row = 0;
            int col = N - i - 1;
            while (row < N && col < N) {
                System.out.print(A[row][col] + " ");
                row++;
                col++;
            }
            System.out.println();
        }

        //loop for bottom triangle
        for (int i = 1; i < N; i++) {
            int row = i;
            int col = 0;
            while (row < N && col <N) {
                System.out.print(A[row][col] + " ");
                row++;
                col++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] A = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9,  10, 11, 12},
                {13, 14, 15, 15}
        };
        //loop to print actual given matrix
        System.out.println("Given matrix:     ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Diagonal Matrix:     ");
        diagonals(A);
    }
}
