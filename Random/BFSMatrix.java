import java.util.*;

class BFSMatrix{

    public static int bfsMatrixTraversal(int[][] grid, int sr, int sc, int tr, int tc){
        Deque<Cell> queue = new ArrayDeque<>();
        queue.offer(new Cell(sr, sc, 0));
        int[][] directions = new int[][]{{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        seen[sc][sr] = true;

        while(!queue.isEmpty()){
            Cell cur = queue.poll();
            if(cur.row == tr && cur.col == tc){
                return cur.path;
            }

            for(int[] dir : directions){
                int newRow = cur.row + dir[0];
                int newCol = cur.col + dir[1];
                if(withinBounds(grid, newRow, newCol) && !seen[newRow][newCol]){
                    seen[newRow][newCol] = true;
                    queue.offer(new Cell(newRow, newCol, cur.path + 1));
                }
            }
        }
        return -1;
    }

    public static boolean withinBounds(int[][] grid, int r, int c){
        return (0 <= r && r < grid.length && 0 <= c && c <= grid[0].length);
    }

    public static void main(String[] args){
      // chumma to be able to compile
      System.out.println("Hello World!");
    }

}

class Cell{
    int row;
    int col;
    int path;

    public Cell(int r, int c, int p){
        this.row = r;
        this.col = c;
        this.path = p;
    }
}