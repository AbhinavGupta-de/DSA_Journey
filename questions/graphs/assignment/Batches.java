package questions.graps.assignment;

public class Batches {

    public int solve(int A, int[] B, int[][] C, int D) {
        return numBatchesWithDStrength(A, B, C, D);
    }

    private int findParent(int node, int[] parent) {
        if(node == parent[node]) return node;
        return parent[node] = findParent(parent[node], parent);
    }

    private void union(int u, int v, int[] parent, int[] rank) {
        int pu = findParent(u, parent);
        int pv = findParent(v, parent);
        if(pu != pv) {
            if(rank[pu] > rank[pv]) {
                parent[pv] = pu;
            } else if(rank[pv] > rank[pu]) {
                parent[pu] = pv;
            } else {
                parent[pu] = pv;
                rank[pv]++;
            }
        }
    }

    public int numBatchesWithDStrength(int numStudents, int[] strength, int[][] edges, int D) {
        int[] parent = new int[numStudents + 1];
        int[] rank = new int[numStudents + 1];

        for(int i = 1; i <= numStudents; i++) {
            parent[i] = i;
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            union(u, v, parent, rank);
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 1; i <= numStudents; i++) {
            int p = findParent(i, parent);
            map.put(p, map.getOrDefault(p, 0) + strength[i - 1]);
        }

        int ans = 0;

        for(int sum : map.values()) {
            if (sum >= D) {
                ans++;
            }
        }

        return ans;
    }

}