class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        int m=intervals[0].length;
        ArrayList<int[]> res=new ArrayList<>();
        int[] ans=new int[2];
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int i=1;i<n;i++){
            if(end>=intervals[i][0]){
                end=Math.max(end,intervals[i][1]);
            }
            else{
                res.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        res.add(new int[]{start,end});
        return res.toArray(new int[res.size()][]);
    }
}