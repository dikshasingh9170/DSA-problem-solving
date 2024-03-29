class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<List<Integer>> hs=new HashSet<>();
        Arrays.sort(candidates);
        count(0,candidates,target,hs,new ArrayList());
        return new ArrayList<>(hs);
    }
    public void count(int idx,int[] candidates,int target,HashSet<List<Integer>> hs,List<Integer> ds){
        if(target==0){
            hs.add(new ArrayList<>(ds));
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i]==candidates[i-1])continue;
            if(candidates[i]>target)break;

            ds.add(candidates[i]);
            count(i+1,candidates,target-candidates[i],hs,ds);
            ds.remove(ds.size()-1);
        }
    }
}