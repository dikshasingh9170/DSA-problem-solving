class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        DisjointSet dsu = new DisjointSet(n * m);

        int count = 0;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    int id1 = i * m + j;

                    for (int[] d : dir) {
                        int ni = i + d[0];
                        int nj = j + d[1];

                        if (ni >= 0 && nj >= 0 && ni < n && nj < m &&
                            grid[ni][nj] == '1') {

                            int id2 = ni * m + nj;
                            int p1 = dsu.findUPar(id1);
                            int p2 = dsu.findUPar(id2);

                            if (p1 != p2) {
                                dsu.unionByRank(p1, p2);
                                count--; 
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
class DisjointSet {
    private int[] rank;
    private int[] size;
    private int[] parent;
    public DisjointSet(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];
        Arrays.fill(size, 1);
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }
    public int findUPar(int node) {
        if (node == parent[node])
            return node;

        return parent[node] = findUPar(parent[node]);
    }
    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) return;
        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        } else if (rank[ulp_v] < rank[ulp_u]) {
            parent[ulp_v] = ulp_u;
        } 
        else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

