package questions.graphs.strivers;

public class PathMinimumEffort {

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] effort = new int[rows][cols];

        for(int i = 0; i < rows; i++){
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }

        effort[0][0] = 0;

        int[] rowDelta = { 1, -1, 0, 0 };
        int[] colDelta = { 0, 0, 1, -1 };

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        pq.add(new int[]{0, 0, 0});

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int x = top[0];
            int y = top[1];
            int e = top[2];

            if(x == rows - 1 && y == cols - 1){
                return e;
            }

            for(int i = 0; i < 4; i++){
                int newRow = x + rowDelta[i];
                int newCol = y + colDelta[i];

                if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols){
                    int newEffort = Math.max(e, Math.abs(heights[newRow][newCol] - heights[x][y]));

                    if(newEffort < effort[newRow][newCol]){
                        effort[newRow][newCol] = newEffort;
                        pq.add(new int[]{newRow, newCol, newEffort});
                    }
                }
            }
        }

        return -1;
    }

}