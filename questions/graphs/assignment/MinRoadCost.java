package questions.graphs.assignment;

public class MinRoadCost {

    public int solve(int[] A, int[] B) {
        return minRoadCost(A, B);
    }

    public int minRoadCost(int[] verticalCost, int[] horizontalCost) {
        int rows = verticalCost.length + 1;
        int colums = horizontalCost.length + 1;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int i = 0; i < rows - 1; i++) {
            pq.add(new int[]{0, verticalCost[i]});
        }

        for (int i = 0; i < colums - 1; i++) {
            pq.add(new int[]{1, horizontalCost[i]});
        }

        int minCost = 0;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            if (top[0] == 0) {
                minCost += top[1] * colums;
                rows--;
            } else {
                minCost += top[1] * rows;
                colums--;
            }
        }

        return minCost;
    }
}