/**
 * 200. Number of Islands
 */
package solutions;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int tally = 0;

        for (int row = 0; row < grid.length; row ++) {
            for (int col = 0; col < grid[0].length; col ++) {
                if (grid[row][col] == '1') {
                    tally ++;
                    clearIsland(grid, row, col);
                }
            }
        }
        return tally;
    }

    void clearIsland(char[][] grid, int row, int col) {
        grid[row][col] = '0';

        if (row > 0 && grid[row-1][col] == '1') {
            clearIsland(grid, row-1, col);
        }
        if (row < grid.length-1 && grid[row+1][col] == '1') {
            clearIsland(grid, row+1, col);
        }
        if (col > 0 && grid[row][col-1] == '1') {
            clearIsland(grid, row, col-1);
        }
        if (col < grid[0].length-1 && grid[row][col+1] == '1') {
            clearIsland(grid, row, col+1);
        }
    }
}
