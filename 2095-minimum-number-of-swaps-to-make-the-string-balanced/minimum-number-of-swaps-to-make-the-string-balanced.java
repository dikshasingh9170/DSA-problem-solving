class Solution {
    public int minSwaps(String s) {
        int size=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='['){
                size++;
            }
            else{
                if(size>0){
                    size--;
                }
            }
        }
        return (size+1)/2;
    }
}