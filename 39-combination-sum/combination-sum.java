class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> ds=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        solution(ds,res,target,0,candidates,0);
        return res;
    }
    public void solution(List<Integer> ds,List<List<Integer>> res,int target,int ans,int[] candidates,int i){
            if(ans==target){
                res.add(new ArrayList<>(ds));
                return;
            }
            if(i>=candidates.length || ans>target){
                return;
            }
            ds.add(candidates[i]);
            solution(ds,res,target,ans+candidates[i],candidates,i);
            ds.remove(ds.size()-1);
        solution(ds,res,target,ans,candidates,i+1);
    }
}