package questions.graph;

public class CycleInUnDirected {
    public booolean hasCycle(int numNodes, int[][] edges) {
        Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();

        for(int[] i : edges) {
            int u = i[0];
            int v = i[1];

            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }

        boolean[] visited = new boolean[numNodes + 1];
        int parent = -1;

        for(int i = 1; i <= numNodes; i++) {
            if(!visited[i]) {
                if(hasCycle(i, adjList, visited, parent)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean hasCycle(int node, Map<Integer, ArrayList<Integer>> adjList, boolean[] visited, int parent) {
        visited[node] = true;

        for(int neighbor : adjList.get(node)) {
            if(!visited[neighbor]) {
                if(hasCycle(neighbor, adjList, visited, node)) {
                    return true;
                }
            } else if(neighbor != parent) {
                return true;
            }
        }

        return false;
    }
}