class Solution {
    public int compress(char[] chars) {
        int j=0;int count=0;int k=0;int n=chars.length;
        for(int i=0;i<chars.length;i++){
            count=0;
            char ch=chars[i];
            while(i<n && ch==chars[i]){
                count++;
                i++;
            }
            if(count==1){
                chars[k++]=ch;
            }
            else{
                chars[k++]=ch;
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[k++] = c;
                }
            }
            i--;
        }
        return k;
    }
}