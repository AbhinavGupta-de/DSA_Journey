package questions.graphs.assignment;

public class CommutableIslands {

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

    private int minCost(int numNodes, int[][] edgeList) {
        List<List<Node>> adjList = new ArrayList<>(); // Changed to store Node objects

        for (int i = 0; i <= numNodes; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edgeList) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adjList.get(u).add(new Node(v, w)); // Store nodes with weights
            adjList.get(v).add(new Node(u, w)); // Store nodes with weights
        }

        boolean[] visited = new boolean[numNodes + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> a.weight)
        );

        pq.add(new Node(1, 0));
        long cost = 0L;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (visited[current.vertex]) {
                continue;
            }

            visited[current.vertex] = true;
            cost += current.weight;

            for (Node neighbor : adjList.get(current.vertex)) { // Iterate over nodes with weights
                if (!visited[neighbor.vertex]) {
                    pq.add(new Node(neighbor.vertex, neighbor.weight)); // Use actual weights
                }
            }
        }

        for (int i = 1; i <= numNodes; i++) {
            if (!visited[i]) {
                return -1; // Graph is not fully connected
            }
        }

        return (int) cost;
    }
}