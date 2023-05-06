class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character> hs=new HashSet<Character>();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');
        int max_sum=0;
        for(int i=0;i<k;i++){
            if(hs.contains(s.charAt(i))){
                max_sum++;
            }
        }
        int window_sum=max_sum;
        for(int i=k;i<s.length();i++){
            if(hs.contains(s.charAt(i))){
                window_sum++;
            }
            if(hs.contains(s.charAt(i-k))){
                window_sum--;
            }
            max_sum=Math.max(max_sum,window_sum);
        }
        return max_sum;
    }
}