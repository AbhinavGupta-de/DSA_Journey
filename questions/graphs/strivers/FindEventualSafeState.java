package questions.graphs.strivers;

public class FindEventualSafeState {
    public boolean dfs(int node, boolean[] visited, boolean[] pathVisited, boolean[] check, int[][] graph) {
        if (visited[node]) {
            if (pathVisited[node]) {
                check[node] = false;
                return false;
            }
            return check[node];
        }

        check[node] = false;
        visited[node] = true;
        pathVisited[node] = true;
        for (int neighbor : graph[node]) {
            if (!dfs(neighbor, visited, pathVisited, check, graph)) {
                pathVisited[node] = false;
                return false;
            }
        }
        check[node] = true;
        pathVisited[node] = false;
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        boolean[] check = new boolean[n];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, pathVisited, check, graph);
            }
        }
        for (int i = 0; i < n; i++) {
            if (check[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}