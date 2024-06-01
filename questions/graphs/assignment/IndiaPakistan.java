package questions.graphs;

public class IndiaPakistan {

    public void solve(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        // Step 1: Mark all 'O's connected to the boundary with a temporary marker
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 'O') {
                dfs(grid, i, 0);
            }
            if (grid[i][cols - 1] == 'O') {
                dfs(grid, i, cols - 1);
            }
        }

        for (int j = 0; j < cols; j++) {
            if (grid[0][j] == 'O') {
                dfs(grid, 0, j);
            }
            if (grid[rows - 1][j] == 'O') {
                dfs(grid, rows - 1, j);
            }
        }

        // Step 2: Convert the remaining 'O' to 'X' and the temporary marks back to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                } else if (grid[i][j] == 'T') {
                    grid[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != 'O') {
            return;
        }

        // Mark this cell as part of the region connected to the boundary
        grid[i][j] = 'T';

        // Recursively call dfs for all four adjacent cells
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

}