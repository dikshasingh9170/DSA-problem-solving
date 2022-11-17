
class Solution {
    public int[] searchRange(int[] nums, int target) {
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
       int j=0;
        ArrayList<Integer> arr=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
            }
            else{
                hm.put(nums[i],1);
            }
            arr.add(nums[i]);
        }
        int[] res=new int[2];
        int s=arr.indexOf(target);
        if(s>=0){
            res[0]=s;
            for(Map.Entry<Integer,Integer> it:hm.entrySet()){
                if(it.getKey()==target){
                    j=it.getValue();
                }
            }
            res[1]=res[0]+j-1;
        }
        else{
            res[0]=-1;
            res[1]=-1;
        }
        
        return res;
    }
}