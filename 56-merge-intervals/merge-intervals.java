class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int start=intervals[0][0];
        int end=intervals[0][1];
        ArrayList<int[]> res=new ArrayList<>();
        for(int i=0;i+1<n;i++){
            if(end>=intervals[i+1][0]){
                end=Math.max(end,intervals[i+1][1]);
            }
            else{
                res.add(new int[]{start,end});
                start=intervals[i+1][0];
                end=intervals[i+1][1];
            }
        }
        res.add(new int[]{start,end});
        return res.toArray(new int[res.size()][]);
    }
}