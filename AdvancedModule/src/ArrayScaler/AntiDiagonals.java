package ArrayScaler;

import java.util.ArrayList;

public class AntiDiagonals {
    public static void antiDiagonals(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int[][] output = new int[N - 1 + M][M];
        //for the first triangle
        for (int i = 0; i < M; i++) {
            int row = 0;
            int col = i;
            while (row < N && col >= 0) {
                System.out.print(A[row][col] + " ");
                row++;
                col--;
            }
            System.out.println();
        }
        //for the second triangle
        for (int i = 1; i < N; i++) {
            int row = i;
            int col = M - 1;
            while (row < N && col >= 0) {
                System.out.print(A[row][col] + " ");
                row++;
                col--;
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> antiDiagonalsWithList(int[][] A) {
        int N = A.length;
        int n = 2*N - 1;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        for (int i = 0; i < n; i++)
            B.add(new ArrayList<>());
        for (int row = 0; row < N; row++)
            for (int col = 0; col < N; col++) B.get(row + col).add(A[row][col]);

        return B;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }

        antiDiagonals(A);
        ArrayList<ArrayList<Integer>> B = antiDiagonalsWithList(A);
        for(int i=0;i<5;i++){
            for(int j:B.get(i)){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        for(ArrayList<Integer> i: B){
            System.out.println( i+" ");
        }
    }
}
