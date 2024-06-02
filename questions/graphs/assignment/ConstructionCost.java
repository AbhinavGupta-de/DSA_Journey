package questions.graphs.assignment;

public class ConstructionCost {
    private class Node {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public int solve(int A, int[][] B) {
        return minCost(A, B);
    }

    private int minCost(int numNodes, int[][] edges) {
        Map<Integer, List<Node>> adjList = new HashMap<>();

        for (int i = 1; i <= numNodes; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adjList.get(u).add(new Node(v, w));
            adjList.get(v).add(new Node(u, w));
        }

        boolean[] visited = new boolean[numNodes + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));

        pq.add(new Node(1, 0));
        long cost = 0l;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (visited[current.vertex]) {
                continue;
            }

            visited[current.vertex] = true;
            cost += current.weight;

            for (Node neighbor : adjList.get(current.vertex)) {
                if (!visited[neighbor.vertex]) {
                    pq.add(neighbor);
                }
            }
        }

        for (int i = 1; i <= numNodes; i++) {
            if (!visited[i]) {
                return -1; // Graph is not connected
            }
        }
        int MOD = (int)(1e9 + 7);
        return (int)(cost%MOD);
}