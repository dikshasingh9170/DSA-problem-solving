class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] cost = new int[n][n];
        for (int[] temp : cost) Arrays.fill(temp, 10001); 

        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], weight = edge[2];
            cost[from][to] = weight;
            cost[to][from] = weight;
        }
        for (int i = 0; i < n; i++) cost[i][i] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    cost[j][k] = Math.min(cost[j][k], cost[j][i] + cost[i][k]);
                }
            }
        }

        int city = -1;
        int minReachable = n;

        for (int j = 0; j < n; j++) {
            int cnt = 0;
            for (int k = 0; k < n; k++) {
                if (cost[j][k] <= distanceThreshold) cnt++;
            }
            if (cnt <= minReachable) {
                minReachable = cnt;
                city = j;
            }
        }
        return city;
    }
}