class Solution {
    public boolean rotateString(String s, String goal) {
        int n=s.length();
        int m=goal.length();
        s=s+s;
        if(s.contains(goal) && n==m){
            return true;
        }
        return false;
    }
}