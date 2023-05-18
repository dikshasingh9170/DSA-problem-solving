class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree=new int[n];
        ArrayList<Integer> adj=new ArrayList<Integer>();
        for(List<Integer> list:edges){
            indegree[list.get(1)]++;
        }
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                adj.add(i);
            }
        }
        return adj;
    }
}