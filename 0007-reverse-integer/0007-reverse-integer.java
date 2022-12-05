class Solution {
    public int reverse(int x) {
        boolean flag;
        if(x>0){
            flag=false;
        }
        else{
            flag=true;
        }
       Long y=Long.valueOf(x);
        Long num=Math.abs(y);
        StringBuilder str=new StringBuilder();
        str=str.append(num);
        str=str.reverse();
        String z=str.toString();
        long ans=Long.parseLong(z);
        if(ans<=2147483647){
            if(flag==true){
               return 0-Integer.parseInt(z);
            }
            else{
                return Integer.parseInt(z);
            }
        }
        else{
            return 0;
        }
    }
}