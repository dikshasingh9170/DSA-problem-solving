//class Solution {
    //public int findDuplicate(int[] nums) {
       // HashSet<Integer> hs=new HashSet<Integer>();
       // for(int i:nums){
          //  if(hs.contains(i)){
           //     return i;
            //}
               // hs.add(i);
        //}
        //return -1;
    //}
//}
class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int ans=0;
        for(int item:nums){
            if(map.containsKey(item)){
                ans=item;
                break;
            }
            else
                map.put(item,1);
        }
        return ans;
    }
}