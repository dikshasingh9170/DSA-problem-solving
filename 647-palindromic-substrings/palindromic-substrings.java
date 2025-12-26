class Solution {
    public int countSubstrings(String s) {
        int n=s.length();int count=0;
        for(int i=0;i<n;i++){
            int odd=expandFromCenter(i,i,n,s);
            int even=expandFromCenter(i,i+1,n,s);
            if(odd==0){
                count++;
            }
            count+=odd+even;
        }
        return count;
    }
    public int expandFromCenter(int i,int j,int n,String s){
        int count=0;
        while(i>=0 && j<n){
            if(s.charAt(i)!=s.charAt(j)){
                return count;
            }
            else{
                count++;
            }
            i--;
            j++;
        }
        return count;
    }
}