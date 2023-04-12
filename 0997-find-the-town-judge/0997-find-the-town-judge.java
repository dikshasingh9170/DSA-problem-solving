class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] deg=new int[n+1];
        Arrays.fill(deg,0);
        for(int[] i:trust){
            deg[i[0]]--;
            deg[i[1]]++;
        }
        for(int i=1;i<deg.length;i++){
            if(deg[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}