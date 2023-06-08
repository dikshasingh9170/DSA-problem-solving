/*class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b)->a[1] - b[1]);
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);
        for (int[] job : jobs) {
            int cur = dp.floorEntry(job[0]).getValue() + job[2];
            if (cur > dp.lastEntry().getValue())
                dp.put(job[1], cur);
        }
        return dp.lastEntry().getValue();
    }
}*/
class Solution {
    private Map<Integer, Integer> dp;
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
         int n1=startTime.length;
        Job jobs[]=new Job[n1];
        for(int i=0;i<n1;i++){
            jobs[i]=new Job(startTime[i],endTime[i],profit[i]);
        }
        Arrays.sort(jobs,new JobComparator());
        int n2=jobs.length;
        int[] dp=new int[n2];int ans=0;
        dp[0]=jobs[0].profit;
        for(int i=1;i<n2;i++){
            int inc=jobs[i].profit;
            int l=binarysearch(jobs,i);
            if(l!=-1){
                inc+=dp[l];
            }
            dp[i]=Math.max(inc,dp[i-1]);
        }
        return dp[n2-1];
    }
    public static int binarysearch(Job jobs[],int i){
        int l=0;int h=i-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(jobs[mid].finish<=jobs[i].start){
                if(jobs[mid+1].finish<=jobs[i].start){
                    l=mid+1;
                }
                else{
                    return mid;
                }
            }
            else{
                h=mid-1;
            }
        }
        return -1;
    }
}
class Job{
    int start,finish,profit;
    Job(int start,int finish,int profit){
        this.start=start;
        this.finish=finish;
        this.profit=profit;
    }
}
class JobComparator implements Comparator<Job>{
    public int compare(Job a,Job b){
        return a.finish<b.finish?-1:a.finish==b.finish?0:1;
    }
}