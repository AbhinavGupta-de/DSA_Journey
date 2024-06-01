package questions.graphs.strivers;

public class BipartiteGraph {
    public boolean isBipartite(int[][] graph) {
//        there are three ways I could think of doing this
//        1. Using BFS
//        2. Using DFS
//        3. Seeing if it is acyclic then it is bipartite
//        ... if it is cyclic then checking the length of the cycle
//        ... if it is even then it is bipartite
//        ... if it is odd then it is not bipartite

//        going with the first approach
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == 0 && !isBipartite(graph, color, i, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean isBipartite(int[][] graph, int[] color, int node, int c) {
        if (color[node] != 0) {
            return color[node] == c;
        }

        color[node] = c;

        for (int neighbor : graph[node]) {
            if (!isBipartite(graph, color, neighbor, -c)) {
                return false;
            }
        }

        return true;
    }
}