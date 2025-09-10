class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*HashSet<Character> hs=new HashSet<Character>();
        int l=0;int r=1;int count=1;int x=1;
        if(s.length()==0){
            return 0;
        }
        if(s.equals(" ") || s.length()==1){
            return 1;
        }
        while(l<s.length()){
	        hs.add(s.charAt(l));
	        while(r<s.length()){
	            hs.add(s.charAt(r));
                x++;
	            if(x!=hs.size()){
                    break;
                }
	            count=Math.max(count,hs.size());
	            r++;
	        }
            x=1;
	        hs.clear();
	        l++;
	        r=l+1;
	    }
        return count;*/
        HashMap<Character, Integer> st = new HashMap<>();
        int ans = 0, l = 0, r = 0;
        
        while (r < s.length()) {
            if (st.containsKey(s.charAt(r))) {
                l = Math.max(l, st.get(s.charAt(r)) + 1);
            }
            st.put(s.charAt(r), r);
            
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        
        return ans;
    }
}
