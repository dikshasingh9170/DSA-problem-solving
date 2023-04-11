class Solution {
    public int findShortestSubArray(int[] nums) {
        TreeMap<Integer,Integer> hm=new TreeMap<Integer,Integer>();
        ArrayList<Integer> arr=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            arr.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
            }
            else{
                hm.put(nums[i],1);
            }
        }
        int x=0;int min=Integer.MAX_VALUE;
        int maxMap = (Collections.max(hm.values()));
        for (Map.Entry<Integer,Integer> entry : hm.entrySet())
        {
            if(entry.getValue()==maxMap){
                 x=arr.lastIndexOf(entry.getKey())-arr.indexOf(entry.getKey())+1;
                 min=Math.min(x,min);
            }
        }
        return min;
    }
}