class Solution {
    public int searchInsert(int[] nums, int target) {
        TreeMap<Integer,Integer> tm=new TreeMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            tm.put(nums[i],i);
        }
        if(tm.containsKey(target)){
            return tm.get(target);
        }
        else{
            Map.Entry<Integer, Integer>value= tm.higherEntry(target);
            if(value==null){
                return tm.size();
            }
            else{
                return value.getValue();
            }
        }
    }
}