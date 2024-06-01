package questions.graphs;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[] rowDelta = { 1, -1, 0, 0 };
        int[] colDelta = {0, 0, 1, -1};

        Queue<int[]> q = new LinkedList<>();

        int minMinutes = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            int n = q.size();
            for(int i = 0; i < n; i++){
                int[] top = q.poll();
                for(int j = 0; j < 4; j++){
                    int newRow = top[0] + rowDelta[j];
                    int newCol = top[1] + colDelta[j];

                    if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2;
                        q.add(new int[]{newRow, newCol});
                    }
                }
            }

            if(!q.isEmpty()){
                minMinutes++;
            }
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return minMinutes;

    }
}