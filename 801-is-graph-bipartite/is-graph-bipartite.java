class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {   // new component
                color[i] = 0;
                q.add(i);

                while (!q.isEmpty()) {
                    int node = q.poll();

                    for (int nei : graph[node]) {
                        if (color[nei] == -1) {
                            color[nei] = 1 - color[node];
                            q.add(nei);
                        } else if (color[nei] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}