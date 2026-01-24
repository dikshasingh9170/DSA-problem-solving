class Solution {
    public int minimumTime(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (n > 1 && m > 1 && grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]   
        );

        pq.add(new int[]{0, 0, 0}); 
        dist[0][0] = 0;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0];
            int r = cur[1];
            int c = cur[2];

            if (r == n - 1 && c == m - 1) return time;
            if (time > dist[r][c]) continue;

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;

                int nextTime = time + 1;

                if (nextTime < grid[nr][nc]) {
                    int diff = grid[nr][nc] - time;
                    if (diff % 2 == 0) nextTime = grid[nr][nc] + 1;
                    else nextTime = grid[nr][nc];
                }

                if (nextTime < dist[nr][nc]) {
                    dist[nr][nc] = nextTime;
                    pq.add(new int[]{nextTime, nr, nc});
                }
            }
        }
        return -1;
    }
}
