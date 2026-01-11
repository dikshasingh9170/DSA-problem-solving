class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int start=0;int max=0;
        for(int end=0;end<s.length();end++){
            if(map.containsKey(s.charAt(end))){
                start=Math.max(start,map.get(s.charAt(end))+1);
            }
            map.put(s.charAt(end),end);
            max=Math.max(max,end-start+1);
        }
        return max;
    }
}