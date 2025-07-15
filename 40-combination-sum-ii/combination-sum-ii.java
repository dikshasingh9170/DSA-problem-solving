class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinationSum=new ArrayList<>();
        List<Integer> combination=new ArrayList<>();
        solution(candidates,target,combinationSum,combination,0,0);
        return combinationSum;
    }
    public void solution(int[] candidates, int target,List<List<Integer>> combinationSum,List<Integer> combination,int index,int sum){
        if(target==sum){
            combinationSum.add(new ArrayList<>(combination));
            return;
        }
        if(index==candidates.length || sum>target){
            return;
        }
        combination.add(candidates[index]);
        sum+=candidates[index];
        solution(candidates,target,combinationSum,combination,index+1,sum);
        combination.remove(combination.size()-1);
        sum-=candidates[index];

        int nextIndex = index + 1;
        while (nextIndex < candidates.length && candidates[nextIndex] == candidates[index]) {
            nextIndex++;
        }
        solution(candidates,target,combinationSum,combination,nextIndex,sum);
    }
}



