class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
        int count=0;int max=0;
        if(s.length()==0){
            return 0;
        }int x=0;
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                if(hm.get(s.charAt(i))>=x){
                    count=i-hm.get(s.charAt(i));
                }
                else{
                    count++;
                }
                x=Math.max(x,hm.get(s.charAt(i)));
                hm.put(s.charAt(i),i);
            }
            else{
                hm.put(s.charAt(i),i);
                count++;
            }
            max=Math.max(count,max);
        }
        return max;
    }
}