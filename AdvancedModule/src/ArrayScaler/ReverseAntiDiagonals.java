package ArrayScaler;

public class ReverseAntiDiagonals {
    /*public static void reverseAntiDiagonals(int[][] A){
        int N = A.length;
        for(int i=0;i<N;i++){
            int row = i;
            int col = 0;
            while(row>=0 && col<N){
                System.out.print(A[row][col]+" ");
                row--;
                col++;
            }
            System.out.println();
        }
        for(int i=1;i<N;i++){
            int row = N-1;
            int col = i;
            while(row>=0 && col<N){
                System.out.print(A[row][col]+" ");
                row--;
                col++;
            }
            System.out.println();
        }
    }*/
    public static void reverseAntiDiagonals(int[][] A){
        int N = A.length;
        for(int i=N-1;i>=0;i--){
            int row = N-1;
            int col = i;
            while (row>=0 && col<N){
                System.out.print(A[row][col]+" ");
                row--;
                col++;
            }
            System.out.println();
        }
        for(int i=N-2;i>=0;i--){
            int row = i;
            int col = 0;
            while(row>=0 && col<N-1){
                System.out.print(A[row][col]+" ");
                row--;
                col++;
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        reverseAntiDiagonals(A);
    }
}
