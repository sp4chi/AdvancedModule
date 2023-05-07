package ArrayScaler;

public class SpiralMatrix {
    public static int[][] spiralMatrix(int N) {
        int[][] B = new int[N][N];
        int temp = 1;
        //loop to build the array
        /*for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] += temp;
                temp++;
            }
        }*/
        //loop to print the array
        /*for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(A[i][j] + "    ");
            }
            System.out.println();
        }*/
        int startingRow = 0;
        int endingCol = N - 1;
        int endingRow = N - 1;
        int startingCol = 0;
        while (startingRow <= endingRow && startingCol <= endingCol) {

            for (int i = startingCol; i <= endingCol; i++){
                B[startingCol][i] += temp;
                temp++;
            }

            startingRow++;

            for (int i = startingRow; i <= endingRow; i++){
                B[i][endingCol] += temp;
                temp++;
            }

            endingCol--;

            if (endingRow >= startingRow) {
                for (int i = endingCol; i >= startingCol; i--) {
                    B[endingRow][i] += temp;
                    temp++;
                }

                endingRow--;
            }

            if (endingCol >= startingCol) {
                for (int i = endingRow; i >= startingRow; i--) {
                    B[i][startingCol] += temp;
                    temp++;
                }

                startingCol++;
            }
        }
        return B;
    }

    public static void main(String[] args) {
        int N = 4;
        int[][] A = spiralMatrix(N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(A[i][j] + "    ");
            }
            System.out.println();
        }
    }
}
