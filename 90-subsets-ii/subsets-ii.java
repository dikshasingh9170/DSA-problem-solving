class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets=new ArrayList<>();
        HashSet<ArrayList<Integer>> hs=new HashSet<>();
        List<Integer> set=new ArrayList<>();
        solution(nums,hs,set,0);
        for(ArrayList<Integer> ds:hs){
            subsets.add(ds);
        }
        return subsets;
    }
    public void solution(int[] nums,HashSet<ArrayList<Integer>> hs,List<Integer> set,int index){
        if(index==nums.length){
            hs.add(new ArrayList<>(set));
            return;
        }
        set.add(nums[index]);
        solution(nums,hs,set,index+1);
        set.remove(set.size()-1);
        int nextIndex = index + 1;
        while (nextIndex < nums.length && nums[nextIndex] == nums[index]) {
            nextIndex++;
        }
        solution(nums,hs,set,nextIndex);
    }
}
