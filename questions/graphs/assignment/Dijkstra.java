package questions.graphs.assignment;

public class Dijkstra {
    public int[] solve(int A, int[][] B, int C) {
        return shortestPath(A, B, C);
    }

    private class Node {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    private int[] shortestPath(int numNodes, int[][] edges, int source) {
        ArrayList<ArrayList<Node>> adjList = new ArrayList<>();

        for (int i = 0; i < numNodes; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adjList.get(u).add(new Node(v, w));
            adjList.get(v).add(new Node(u, w));
        }

        int[] dist = new int[numNodes];

        for(int i = 0; i < numNodes; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));

        pq.add(new Node(source, 0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();

            if(dist[current.vertex] < current.weight) {
                continue;
            }

            dist[current.vertex] = current.weight;

            for(Node neighbor : adjList.get(current.vertex)) {
                if(dist[neighbor.vertex] > dist[current.vertex] + neighbor.weight) {
                    dist[neighbor.vertex] = dist[current.vertex] + neighbor.weight;
                    pq.add(new Node(neighbor.vertex, dist[neighbor.vertex]));
                }
            }

        }

        for(int i = 0; i < numNodes; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return  dist;
    }
}