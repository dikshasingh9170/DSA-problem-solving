class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        else{
            Arrays.sort(nums);
            ArrayList<Integer> arr=new ArrayList<Integer>();
            for(int i=0;i+1<nums.length;i++){
                arr.add(nums[i+1]-nums[i]);
            }
            return Collections.max(arr);
        }
    }
}