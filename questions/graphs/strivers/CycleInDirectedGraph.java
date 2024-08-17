package questions.graphs;

public class CycleInDirectedGraph {
    public int solve(int numNodes, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i <= numNodes; i++) {
            adjList.add(new ArrayList());
        }

        for(int[] i : edges) {
            int u = i[0];
            int v = i[1];

            adjList.get(u).add(v);
        }

        boolean[] visited = new boolean[numNodes + 1];
        int parent = -1;

        for(int i = 1; i <= numNodes; i++) {
            if(!visited[i]) {
                if(hasCycle(i, adjList, visited, parent)) {
                    return 1;
                }
            }
        }

        return 0;
    }

    private boolean hasCycle(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, int parent) {
        visited[node] = true;

        for(int neighbor : adjList.get(node)) {
            if(neighbor != parent){
                if(visited[neighbor]) return true;
                else if (hasCycle(neighbor,adjList,visited,node)) return true;
            }
        }
        return false;
    }
}