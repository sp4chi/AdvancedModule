package ArrayScaler;

public class SearchIn2DSortedArray {
    //given a 2d array which is sorted along rows and columns, find out a given element.
    public static int[] search2D(int[][] A, int target) {
        int M = A.length;
        int N = A[0].length;

        int row = 0;
        int col = N - 1;

        while (row < M && col >= 0) {
            if (A[row][col] == target) {
                return new int[]{row, col};
            } else if (A[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] A = {
                {2, 4, 7, 12},
                {5, 6, 9, 15},
                {11, 14, 20, 25},
                {16, 17, 22, 34}
        };
        int target = 17;
        System.out.println("Found in row: "+search2D(A, target)[0] + " col: " + search2D(A,target)[1]);
    }
}
