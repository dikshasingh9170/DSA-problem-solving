class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            arr.add(new ArrayList<>());
        }
        for(int[] i:prerequisites){
            arr.get(i[1]).add(i[0]);
        }
        boolean[] vis=new boolean[numCourses];
        boolean[] pvis=new boolean[numCourses];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(!dfs(i,arr,vis,pvis,st)){
                    return new int[0];
                }
            }
        }
        int[] res=new int[numCourses];int i=0;
        while(!st.isEmpty()){
            res[i++]=st.pop();
        }
        return res;
    }
    public boolean dfs(int i,ArrayList<ArrayList<Integer>> arr,boolean[] vis,boolean[] pvis,Stack<Integer> st){
        vis[i]=true;
        pvis[i]=true;
        for(int j:arr.get(i)){
            if(!vis[j]){
                if(!dfs(j,arr,vis,pvis,st)){
                    return false;
                }
            }
            else if(pvis[j]){
                return false;
            }
        }
        pvis[i]=false;
        st.add(i);
        return true;
    }
}