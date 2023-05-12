class Solution {
    public int repeatedStringMatch(String a, String b) {
        
        String copy = "";
        int count=0;
        while(copy.length()<b.length()){
            copy+=a;
            count++;
        }
        if(copy.indexOf(b)>=0)
            return count;
        if((copy+a).indexOf(b)>=0)
            return ++count;
        return -1;
    }
}