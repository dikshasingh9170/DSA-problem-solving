class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, -1);

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int nr = cur[0] + dr[k];
                int nc = cur[1] + dc[k];
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        boolean[][] vis = new boolean[n][n];
        pq.offer(new int[]{dist[0][0], 0, 0});
        vis[0][0] = true;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int safety = cur[0], r = cur[1], c = cur[2];

            if (r == n - 1 && c == n - 1) return safety;

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    pq.offer(new int[]{
                        Math.min(safety, dist[nr][nc]),
                        nr, nc
                    });
                }
            }
        }

        return 0;
    }
}
