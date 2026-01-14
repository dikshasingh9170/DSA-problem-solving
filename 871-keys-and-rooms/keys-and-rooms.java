class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] vis=new int[rooms.size()];
        dfs(0,rooms,vis);
        for(int i=0;i<vis.length;i++){
            if(vis[i]==0){
                return false;
            }
        }
        return true;
    }
    public void dfs(int i,List<List<Integer>> rooms,int[] vis){
        vis[i]=1;
        for(int j:rooms.get(i)){
            if(vis[j]!=1){
                dfs(j,rooms,vis);
            }
        }
    }
}