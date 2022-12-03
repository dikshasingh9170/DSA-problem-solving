class Solution {
    public int pivotInteger(int n) {
        int first=0;int last=0;
        for(int i=1;i<=n/2;i++){
            first+=i;
        }
        for(int i=n/2;i<=n;i++){
            last+=i;
        }
        int l=n/2;
        int z=n/2;
        if(n==1){
            return 1;
        }
        while(first!=last && z!=0){
            first+=(l+1);
            last-=l;
            z--;
            l++;
        }
        if(z==0){
            return -1;
        }
        else{
            return l;
        }
    }
}