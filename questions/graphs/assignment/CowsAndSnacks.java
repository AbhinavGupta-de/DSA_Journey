package questions.graphs.assignment;

public class CowsAndSnacks {
    public int solve(int A, int[][] B) {
        return numSadCows(A, B);
    }

    private int findParent(int node, int[] parent) {
        if(node == parent[node]) return node;
        return parent[node] = findParent(parent[node], parent);
    }

    private boolean union(int u, int v, int[] parent, int[] rank) {
        int pu = findParent(u, parent);
        int pv = findParent(v, parent);

        if(pu == pv) {
            return true; // Cycle detected
        } else {
            if(rank[pu] > rank[pv]) {
                parent[pv] = pu;
            } else if(rank[pv] > rank[pu]) {
                parent[pu] = pv;
            } else {
                parent[pu] = pv;
                rank[pv]++;
            }
            return false; // No cycle detected
        }
    }

    public int numSadCows(int numPeople, int[][] edges) {
        int[] parent = new int[numPeople + 1];
        int[] rank = new int[numPeople + 1];

        for(int i = 1; i <= numPeople; i++) {
            parent[i] = i;
        }

        int sadPeople = 0;

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (union(u, v, parent, rank)) {
                sadPeople++;
            }
        }

        return sadPeople;
    }
}