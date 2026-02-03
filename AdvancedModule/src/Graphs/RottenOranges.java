package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static int rottenOranges(int[][] oranges){
        int N = oranges.length;
        int M = oranges[0].length;

        int[][] distance = new int[N][M];
        for(int[] row : distance){
            Arrays.fill(row, -1);
        }

        int maxDays = 0;
        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(oranges[i][j] == 2){
                    distance[i][j] = 0;
                    queue.add(new int[]{i,j});
                } else if (oranges[i][j] == 1) {
                    freshOranges++; //calc total fresh oranges
                }
            }
        }


        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};

        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];


            for(int i=0;i<4;i++){
                int X = x + dr[i];
                int Y = y + dc[i];

                if(X>=0 && X<N && Y>=0 && Y<M && oranges[X][Y] == 1 && distance[X][Y] == -1){
                    distance[X][Y] = distance[x][y] + 1;
                    queue.add(new int[]{X,Y});
                    maxDays = Math.max(maxDays,distance[X][Y]);
                    freshOranges--; // decrement fresh oranges after they rot
                }
            }
        }

        /*int maxDays = -1;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){

            }
        }*/

        // check needed for case - no fresh oranges in the given array -> return 0
        return freshOranges == 0 ? maxDays: 0;

    }
    public static void main(String[] args) {
        int[][] oranges={
                {1,0,1,2,1},
                {1,1,1,1,1},
                {0,2,0,1,0},
                {0,1,1,1,1},
                {1,1,1,2,0}
        };
        System.out.println(rottenOranges(oranges));

    }
}
