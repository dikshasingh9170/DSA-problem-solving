class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int x=mainTank/5;int ans=0;
        while(mainTank>=5){
            ans+=5*10;
            mainTank=mainTank-5;
            if(additionalTank>=1){
                mainTank++;
                additionalTank--;
            }
        }
        ans+=mainTank*10;
        return ans;
    }
}