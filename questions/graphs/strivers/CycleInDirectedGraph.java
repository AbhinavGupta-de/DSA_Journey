package questions.graphs;

public class CycleInDirectedGraph {
    public boolean hasCycle(int numNodes, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i <= numNodes; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adjList.get(u).add(v);
        }

        boolean[] visited = new boolean[numNodes + 1];
        boolean[] recStack = new boolean[numNodes + 1];

        for(int i = 1; i <= numNodes; i++){
            if(hasCycle(i, adjList, visited, recStack)){
                return true;
            }
        }

        return false;
    }

    private boolean hasCycle(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        for(int neighbor : adjList.get(node)){
            if(!visited[neighbor]){
                if(hasCycle(neighbor, adjList, visited, recStack)){
                    return true;
                }
            } else if(recStack[neighbor]){
                return true;
            }
        }

        return recStack[node] = false;
    }
}