package questions.graphs;

import java.util.*;

public class PathInDirectedGraph {

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        return pathExists(A, B) ? 1 : 0;
    }

    private boolean pathExists(int destination, ArrayList<ArrayList<Integer>> edgeList) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (ArrayList<Integer> edge : edgeList) {
            int u = edge.get(0);
            int v = edge.get(1);
            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        visited.add(1);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == destination) {
                return true;
            }

            List<Integer> neighbors = adjList.get(node);
            if (neighbors != null) {
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
        return false;
    }
}