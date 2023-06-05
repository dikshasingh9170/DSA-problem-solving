class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
            }
            else{
                hm.put(nums[i],1);
            }
        }
        int k=nums.length/2;
        for(Map.Entry<Integer,Integer> e:hm.entrySet()){
            if(e.getValue()>k){
                return e.getKey();
            }
        }
        return -1;
    }
}