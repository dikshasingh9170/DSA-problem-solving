class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res=new ArrayList<>();
        if(edges.length==0 && n>0){
            for(int i=0;i<n;i++){
                res.add(i);
            }
        }
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        int[] inDegree=new int[n];
        for(int i=0;i<n;i++){
            arr.add(new ArrayList<>());
        }
        for(int[] e:edges){
            arr.get(e[0]).add(e[1]);
            arr.get(e[1]).add(e[0]);
            inDegree[e[0]]++;
            inDegree[e[1]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDegree[i]==1){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int size=q.size();
            res=new ArrayList<>();
            while(size-->0){
                int x=q.poll();
                res.add(x);
                for(int e:arr.get(x)){
                    inDegree[e]--;
                    if(inDegree[e]==1){
                        q.add(e);
                    }
                }
            }
        }
        return res;
    }
}