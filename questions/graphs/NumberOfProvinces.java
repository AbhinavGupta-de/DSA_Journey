package questions.graphs;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(isConnected, visited, i);
                provinces++;
            }
        }

        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        visited[i] = true;
        for(int j = 0; j < isConnected.length; j++){
            if(isConnected[i][j] == 1 && !visited[j]){
                dfs(isConnected, visited, j);
            }
        }
    }
}