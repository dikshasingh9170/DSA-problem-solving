class Solution {
    public long minimumSteps(String s) {
        int l=0;int r=s.length()-1;
        long c=0;long ans=0;
        while(l<=r){
            if(s.charAt(l)=='1'){
                c++;
            }
            else{
                ans+=c;
            }
            l++;
        }
        return ans;
    }
}