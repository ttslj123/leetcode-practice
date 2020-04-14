// Wall_and_gate
package java_leetcode;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution test = new Solution();
        int[][] ans = {{3 , -1 ,  0 ,  1},
                       {2 ,  2 ,  1 , -1},
 //                      {1 , -1 ,  2 , -1},
                       {0 , -1 ,  3  , 4}};
        
        int[][] rooms = {{ Integer.MAX_VALUE, -1 ,  0 ,  Integer.MAX_VALUE},
                       {Integer.MAX_VALUE ,  Integer.MAX_VALUE ,  Integer.MAX_VALUE , -1},
  //                     {Integer.MAX_VALUE , -1 ,  Integer.MAX_VALUE , -1},
                       {0 , -1 ,  Integer.MAX_VALUE  , Integer.MAX_VALUE}};
                

        
        int[][] m = test.wallsAndGates(rooms);
        System.out.println("rooms is: ");
        print2D(rooms);
        System.out.println("expected ans is: ");
        print2D(ans);
        System.out.println("your ans is: ");
        print2D(m);

    }
    private static class Cell implements Comparable<Cell>{
      int row, col, dis;
      public Cell(int row, int col, int dis) {
        this.row = row;
        this.col = col;
        this.dis = dis;
      }
      @Override
      public int compareTo(Cell c){
        return Integer.compare(dis, c.dis);
      }
    }
    public int[][] wallsAndGates(int[][] rooms) {
      // Write your solution here
      int m = rooms.length;
      if(m == 0) return rooms;
      int n = rooms[0].length;
      if(n == 0) return rooms;
      
      
      int[][] dp = rooms; // store the distance to the nearest gate for [i][j]

  
      for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
          if(rooms[i][j] == 0) {
            getMinDistance(rooms, m, n, i, j, dp);
          }
        }
      }
  
      return dp;
    }
  
    private void getMinDistance(int[][] rooms, int m, int n, int gateRow, int gateCol, int[][] dp) {
      PriorityQueue<Cell> unvisited = new PriorityQueue<>();
      boolean[][] visited = new boolean[m][n];
      unvisited.offer(new Cell(gateRow, gateCol, 0));
      while(!unvisited.isEmpty()) {
        Cell cur = unvisited.poll();
        int r = cur.row;
        int c = cur.col;
        int d = cur.dis;
        if(visited[r][c]) continue;
        if(r - 1 >= 0 && !visited[r-1][c] && rooms[r-1][c] != -1) {
          unvisited.offer(new Cell(r-1, c, d+1));
        }
        if(r + 1 < m && !visited[r+1][c] && rooms[r+1][c] != -1) {
          unvisited.offer(new Cell(r+1, c, d+1));
        }
        if(c - 1 >= 0 && !visited[r][c-1] && rooms[r][c-1] != -1) {
          unvisited.offer(new Cell(r, c-1, d+1));
        }
        if(c + 1 < n && !visited[r][c+1] && rooms[r][c+1] != -1) {
          unvisited.offer(new Cell(r, c+1, d+1));
        }
        visited[r][c] = true;
        dp[r][c] = Math.min(dp[r][c], d);
      }
    }

    public static void print2D(int mat[][]) 
    { 
        // Loop through all rows 
        for (int i = 0; i < mat.length; i++) 
  
            // Loop through all elements of current row 
            for (int j = 0; j < mat[i].length; j++) 
                System.out.print(mat[i][j] + " ");
            
            System.out.println();
    }
  }
  