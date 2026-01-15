class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            arr.add(new ArrayList<>());
        }
        for(int[] i:prerequisites){
            arr.get(i[1]).add(i[0]);
        }
        boolean[] vis=new boolean[numCourses];
        boolean[] pvis=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(!dfs(i,arr,vis,pvis)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int i,ArrayList<ArrayList<Integer>> arr,boolean[] vis,boolean[] pvis){
        vis[i]=true;
        pvis[i]=true;
        for(int j:arr.get(i)){
            if(!vis[j]){
                if(!dfs(j,arr,vis,pvis)){
                    return false;
                }
            }
            else if(pvis[j]){
                return false;
            }
        }
        pvis[i]=false;
        return true;
    }
}