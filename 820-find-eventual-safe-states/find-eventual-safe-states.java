class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int[] state=new int[n];
        List<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(dfs(i,graph,state)){
                arr.add(i);
            }
        }
        return arr;
    }
    public boolean dfs(int i,int[][] graph,int[] state){
        if(state[i]!=0){
            return state[i]==2;
        }
        state[i]=1;
        for(int j:graph[i]){
            if(!dfs(j,graph,state)){
                return false;
            }
        }
        state[i]=2;
        return true;
    }
}