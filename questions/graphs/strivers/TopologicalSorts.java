package questions.graphs.strivers;

public class TopologicalSorts {
        public int[] solve(int A, int[][] B) {
            int[] ans = new int[A];
            int[] in = new int[A + 1];
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i <= A; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < B.length; i++) {
                int from = B[i][0];
                int to = B[i][1];
                adj.get(from).add(to);
                in[to] = in[to] + 1;
            }

            for (int i = 1; i < in.length; i++) {
                if (in[i] == 0) {
                    pq.add(i);
                }
            }

            int k = 0;
            int z = 0;
            while (!pq.isEmpty()) {
                z++;
                int temp = pq.poll();
                ans[k] = temp;
                k++;
                ArrayList<Integer> t = adj.get(temp);
                for (int j = 0; j < t.size(); j++) {
                    int node = t.get(j);
                    in[node] = in[node] - 1;
                    if (in[node] == 0) {
                        pq.add(node);
                    }
                }
            }
            if(z==0){
                return new int[0];
            }
            return ans;
        }
}