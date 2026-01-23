class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int wt = Math.abs(points[i][0] - points[j][0]) +
                         Math.abs(points[i][1] - points[j][1]);

                adj.get(i).add(new int[]{j, wt});
                adj.get(j).add(new int[]{i, wt});
            }
        }
        boolean[] vis = new boolean[n];
        PriorityQueue<int[]> pq =new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0, 0}); 
        int totalCost = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int wt = cur[0];
            int node = cur[1];

            if (vis[node]) continue;

            vis[node] = true;
            totalCost += wt;

            for (int[] nei : adj.get(node)) {
                if (!vis[nei[0]]) {
                    pq.add(new int[]{nei[1], nei[0]});
                }
            }
        }

        return totalCost;
    }
}