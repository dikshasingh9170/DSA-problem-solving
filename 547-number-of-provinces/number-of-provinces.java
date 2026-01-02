class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                bfs(i, isConnected, vis);
                provinces++;
            }
        }
        return provinces;
    }

    private void bfs(int start, int[][] isConnected, boolean[] vis) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        vis[start] = true;

        while (!q.isEmpty()) {
            int city = q.poll();
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[city][j] == 1 && !vis[j]) {
                    vis[j] = true;
                    q.add(j);
                }
            }
        }
    }
}
