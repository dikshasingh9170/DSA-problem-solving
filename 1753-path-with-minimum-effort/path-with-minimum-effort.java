class Solution {
    public int minimumEffortPath(int[][] heights) {
       int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[2] - b[2]);

        pq.add(new int[]{0, 0, 0});
        dist[0][0] = 0;
         int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0], c = cur[1], effort = cur[2];

            if (r == n-1 && c == m-1)
                return effort;

            if (effort > dist[r][c]) continue;

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m)
                    continue;

                int edge = Math.abs(
                    heights[r][c] - heights[nr][nc]
                );

                int newEffort = Math.max(effort, edge);

                if (newEffort < dist[nr][nc]) {
                    dist[nr][nc] = newEffort;
                    pq.add(new int[]{nr, nc, newEffort});
                }
            }
        }
        return 0;
    }
}