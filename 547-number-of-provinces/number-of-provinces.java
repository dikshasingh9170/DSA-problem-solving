class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < isConnected.length; i++) {
            for(int j=0;j<isConnected[i].length;j++){
                if(isConnected[i][j]==1){
                    arr.get(i).add(j);
                }
            }
        }
        int cnt=0;
        int[] vis=new int[arr.size()];
        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == 0) {
                cnt++;
                bfs(i, arr, vis);
            }
        }
        return cnt;
    }
    private void bfs(int start, List<List<Integer>> arr, int[] vis) {
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        vis[start]=1;
        while(!q.isEmpty()){
            int x=q.poll();
            for(int e:arr.get(x)){
                if(vis[e]!=1){
                    vis[e]=1;
                    q.add(e);
                }
            }
        }
    }
}