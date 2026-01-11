class Solution {
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> q=new LinkedList();int max=0;int curr=0;
        for(int i=0;i<s.length();i++){
            if(q.contains(s.charAt(i))){
                curr=q.size();
                max=Math.max(max,curr);
                while(!q.isEmpty() && q.peek()!=s.charAt(i)){
                    q.poll();
                }
                q.poll();
            }
            q.add(s.charAt(i));
        }
        return Math.max(q.size(),max);
    }
}