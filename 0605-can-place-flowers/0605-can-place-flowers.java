class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0){
            return true;
        }int sum=0;
        if(flowerbed.length==1 && flowerbed[0]==0){
            sum++;
        }
        int prev=-1;int next=-1;
        for(int i=0;i+1<flowerbed.length;i++){
            next=flowerbed[i+1];
            if(flowerbed[i]==0 && prev!=1 && next!=1){
                flowerbed[i]=1;
                sum++;
            }
            prev=flowerbed[i];
        }
        if(next==0 && prev==0){
            sum++;
        }
        if(sum>=n){
            return true;
        }
        return false;
    }
}