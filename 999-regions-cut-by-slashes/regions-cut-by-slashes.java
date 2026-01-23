class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int size = 3 * n;
        int[][] arr = new int[3 * n][3 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int r = i * 3, c = j * 3;
                if (grid[i].charAt(j) == '/') {
                    arr[r][c + 2] = 1;
                    arr[r + 1][c + 1] = 1;
                    arr[r + 2][c] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    arr[r][c] = 1;
                    arr[r + 1][c + 1] = 1;
                    arr[r + 2][c + 2] = 1;
                }
            }
        }
        DSU ds = new DSU(size * size);

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[i][j] == 0) {
                    int id1 = i * size + j;

                    for (int d = 0; d < 4; d++) {
                        int ni = i + dr[d];
                        int nj = j + dc[d];

                        if (ni >= 0 && nj >= 0 && ni < size && nj < size
                                && arr[ni][nj] == 0) {
                            int id2 = ni * size + nj;
                            ds.union(id1, id2);
                        }
                    }
                }
            }
        }
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[i][j] == 0) {
                    int id = i * size + j;
                    set.add(ds.find(id));
                }
            }
        }

        return set.size();
    }
}
class DSU {
    int[] parent;

    DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            parent[px] = py;
        }
    }
}