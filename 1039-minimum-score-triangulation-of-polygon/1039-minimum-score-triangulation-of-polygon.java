class Solution {
    public int minScoreTriangulation(int[] values) {
        int[][] t=new int[values.length][values.length];
        int min=Integer.MAX_VALUE;
        return solve(1,values.length-1,values,Integer.MAX_VALUE,t);
    }
    public int solve(int i,int j,int arr[],int min,int[][] t){
        if(i>=j){
            return 0;
        }
        if(t[i][j]!=0){
            return t[i][j];
        }
        for(int k=i;k<j;k++){
            int temp=solve(i,k,arr,min,t)+solve(k+1,j,arr,min,t)+(arr[i-1]*arr[k]*arr[j]);
            min=Math.min(temp,min);
        }
        return t[i][j]=min;
    }
}