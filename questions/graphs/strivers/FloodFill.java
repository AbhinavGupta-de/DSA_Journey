package questions.graphs;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q = new LinkedList<>();
        int startColor = image[sr][sc];
        if(startColor == color) return image;
        q.add(new int[] { sr, sc });

        int[] rowDelta = { 1, -1, 0, 0 };
        int[] colDelta = { 0, 0, 1, -1 };

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int[] top = q.poll();
                image[top[0]][top[1]] = color;

                for (int j = 0; j < 4; j++) {
                    int newRow = top[0] + rowDelta[j];
                    int newCol = top[1] + colDelta[j];

                    if (newRow >= 0 && newRow < image.length && newCol >= 0 && newCol < image[0].length
                            && image[newRow][newCol] == startColor) {
                        q.add(new int[] { newRow, newCol });
                    }
                }
            }
        }

        return image;
    }
}