package questions.graphs.strivers;

public class ShortestPathInBinaryMaze {

    private class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        if(grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) return -1;

        Queue<Coordinate> q = new LinkedList<>();

        int rows = grid.length;
        int cols = grid[0].length;

        q.add(new Coordinate(0, 0));
        grid[0][0] = 1;

        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Coordinate top = q.poll();
                int x = top.x;
                int y = top.y;

                if(x == rows - 1 && y == cols - 1) return level;

                int[] rowDelta = { 1, -1, 0, 0, 1, -1, 1, -1 };
                int[] colDelta = { 0, 0, 1, -1, 1, -1, -1, 1 };

                for(int j = 0; j < 8; j++) {
                    int newRow = x + rowDelta[j];
                    int newCol = y + colDelta[j];

                    if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 0) {
                        q.add(new Coordinate(newRow, newCol));
                        grid[newRow][newCol] = 1;
                    }
                }
            }

            level++;
        }

        return -1;
    }

}