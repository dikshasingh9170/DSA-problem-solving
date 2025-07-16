class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinationSum = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        solution(candidates, target, combinationSum, combination, 0, 0);
        return combinationSum;
    }

    public void solution(int[] candidates, int target, List<List<Integer>> combinationSum, List<Integer> combination, int index, int sum) {
        if (sum == target) {
            combinationSum.add(new ArrayList<>(combination));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(i!=index && candidates[i]==candidates[i-1])continue;

            if (sum + candidates[i] > target) break;
            
            combination.add(candidates[i]);
            solution(candidates, target, combinationSum, combination, i + 1, sum + candidates[i]);
            combination.remove(combination.size() - 1);
        }
    }
}
