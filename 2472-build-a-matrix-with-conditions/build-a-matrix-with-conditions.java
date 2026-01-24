class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
         List<Integer> rowOrder = topoSort(k, rowConditions);
        List<Integer> colOrder = topoSort(k, colConditions);
        if (rowOrder.size() < k || colOrder.size() < k)
            return new int[0][0];

        int[] rowPos = new int[k + 1];
        int[] colPos = new int[k + 1];
        for(int i=0;i<k;i++){
            rowPos[rowOrder.get(i)]=i;
            colPos[colOrder.get(i)]=i;
        }
        int[][] matrix=new int[k][k];
        for(int num=1;num<=k;num++){
            matrix[rowPos[num]][colPos[num]]=num;
        }
        return matrix;
    }
    private List<Integer> topoSort(int k, int[][] conditions) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= k; i++) graph.add(new ArrayList<>());

        int[] indegree = new int[k + 1];

        for (int[] c : conditions) {
            graph.get(c[0]).add(c[1]);
            indegree[c[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        List<Integer> order = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            order.add(node);
            for (int nei : graph.get(node)) {
                if (--indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        return order;
    }
}