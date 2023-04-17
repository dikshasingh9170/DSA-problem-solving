class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        HashSet<Integer> hs=new HashSet<Integer>();
        for(int i=0;i<candies.length;i++){
            hs.add(candies[i]);
        }
        int max=Collections.max(hs);
        ArrayList<Boolean> arr=new ArrayList<Boolean>();
        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies>=max){
                arr.add(true);
            }
            else{
                arr.add(false);
            }
        }
        return arr;
    }
}