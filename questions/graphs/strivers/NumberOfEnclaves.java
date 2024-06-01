package questions.graph.strivers;

public class NumberOfEnclaves {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

//        marking all the boundary connected 1 with 2
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 1) dfs(grid, i, 0);

            if (grid[i][cols - 1] == 1) dfs(grid, i, cols - 1);
        }

        for (int j = 0; j < cols; j++) {
            if (grid[0][j] == 1) dfs(grid, 0, j);

            if (grid[rows - 1][j] == 1) dfs(grid, rows - 1, j);
        }

        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) count++;
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

         if(i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != 1) {
             return;
         }

        grid[i][j] = 2;

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}