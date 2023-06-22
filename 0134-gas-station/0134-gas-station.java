class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int etc=0;int index=0;int total=0;int temp=0;
        for(int i=0;i<gas.length;i++){
            total+=gas[i]-cost[i];
            temp+=gas[i]-cost[i];
            if(temp<0){
                index=i+1;
                temp=0;
            }
        }
        return (total<0)?-1:index;
    }
}