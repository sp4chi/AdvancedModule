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

        int maxDays = -1;
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(oranges[i][j] == 2){
                    distance[i][j] = 0;
                    queue.add(new int[]{i,j});
                }
            }
        }

        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            int[] dr = {1,-1,0,0};
            int[] dc = {0,0,1,-1};

            for(int i=0;i<4;i++){
                int X = x + dr[i];
                int Y = y + dc[i];

                if(X>=0 && X<N && Y>=0 && Y<M && oranges[X][Y] == 1 && distance[X][Y] == -1){
                    distance[X][Y] = distance[x][y] + 1;
                    queue.add(new int[]{X,Y});

                    maxDays = Math.max(maxDays,distance[X][Y]);
                }
            }
        }

        /*int maxDays = -1;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){

            }
        }*/

        return maxDays;

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
