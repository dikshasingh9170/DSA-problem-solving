class Solution {
    public int minOperations(String[] logs) {
        String parent="../";
        String same="./";
        int curr=0;
        for(int i=0;i<logs.length;i++){
            if(logs[i].equals(parent)){
                if(curr>0)curr--;
            }
            else if(logs[i].equals(same)){
                continue;
            }
            else{
                curr++;
            }
        }
        return curr<0?0:curr;
    }
}