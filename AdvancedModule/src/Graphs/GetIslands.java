package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GetIslands {

    // Problem -  Given a 2d matrix with 1' and 0's find no. of islands.
    // An island is an area of connected 1's. Ex - A[x][y] = 1, A[x][y+1] = 1, is an island.
    // So is A[x][y] = 1, A[x-1][y] = 1, A[x][y+1] = 1

    // approach - traverse the matrix, when you find an unvisited cell with 1, increment
    // island count and bfs/dfs on it.
    /*public static void bfs(int[] start, int[][] A, boolean[][] visited){
        int i = start[0];
        int j = start[1];

        Queue<int[] > queue = new LinkedList<>();

        visited[i][j] = true;
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()){

            int[] cell = queue.poll();

            int row = cell[0];
            int col = cell[1];



            if(A[row]!visited[i][j+1] ) {
                visited[i][j+1] = true;
                queue.add(new int[]{i,j+1});
            }
        }

    }*/
    public static int getIslands(int[][] A, boolean[][] visited){
        int islands = 0;
        Queue<int[]> queue = new LinkedList<>();
        int N = A.length;
        int M = A[0].length;

        for(int row=0;row<N;row++){
            for(int col=0;col<M;col++){
                if(A[row][col] == 1 && !visited[row][col]){
                    islands++;
                    visited[row][col] = true;
                    queue.add(new int[]{row,col});

                    while (!queue.isEmpty()){
                        int[] cell = queue.poll();
                        int i = cell[0];
                        int j = cell[1];

                        int[] dr = {1,-1,0,0};
                        int[] dc = {0,0,-1,1};

                        for (int k = 0; k < 4; k++) {
                            int nr = i + dr[k];
                            int nc = j + dc[k];

                            if (nr >= 0 && nr < N &&
                                    nc >= 0 && nc < M &&
                                    A[nr][nc] == 1 &&
                                    !visited[nr][nc]) {

                                visited[nr][nc] = true;
                                queue.add(new int[]{nr, nc});
                            }
                        }

                        /*if(i<N && j<M && A[i][j+1] == 1 && !visited[i][j+1]){
                            visited[i][j+1] = true;
                            queue.add(new int[]{i,j+1});
                        }

                        if(i<N && j<M && A[i][j-1] == 1 && !visited[i][j-1]){
                            visited[i][j-1] = true;
                            queue.add(new int[]{i,j-1});
                        }

                        if(i<N && j<M && A[i+1][j] == 1 && !visited[i+1][j]){
                            visited[i+1][j] = true;
                            queue.add(new int[]{i+1,j});
                        }

                        if(i<N && j<M && A[i-1][j] == 1 && !visited[i-1][j]){
                            visited[i-1][j] = true;
                            queue.add(new int[]{i-1,j});
                        }*/
                    }
                }
            }
        }

        return islands;
    }

    public static void main(String[] args) {
        /*int[][] A = {
                {1,1,0,1},
                {0,1,0,1},
                {0,0,1,1},
                {1,0,1,0},
                {1,0,1,0}
        };//ans - 3. Confirm!*/
        int[][] A={
                {1,1,1,1},
                {1,0,0,1},
                {1,1,1,1}
        }; //input with a cycle, ans - 1

        // visited arr init -
        int N = A.length;
        int M = A[0].length;
        boolean[][] visited = new boolean[N][M];
        for(boolean[] row : visited) {
            Arrays.fill(row, false);
        }


        System.out.println(getIslands(A,visited));

    }
}
