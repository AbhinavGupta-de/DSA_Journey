package questions.graphs.strivers;

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[][] dist = new int[rows][cols];

        Arrays.stream(dist).forEach(row -> Arrays.fill(row, -1));

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(mat[i][j] == 0){
                    dist[i][j] = 0;
                    q.add(new int[]{i, j});
                }
            }
        }

        int[] rowDelta = {1, -1, 0, 0};
        int[] colDelta = {0, 0, 1, -1};

        while(!q.isEmpty()) {
            int n = q.size();
            for(int i = 0; i < n; i++){
                int[] top = q.poll();
                for(int j = 0; j < 4; j++){
                    int newRow = top[0] + rowDelta[j];
                    int newCol = top[1] + colDelta[j];

                    if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && dist[newRow][newCol] == -1) {
                        dist[newRow][newCol] = dist[top[0]][top[1]] + 1;
                        q.add(new int[]{newRow, newCol});
                    }
                }
            }
        }

        return dist;
    }
}