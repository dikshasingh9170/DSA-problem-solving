class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> prev=new ArrayList<>();
        prev.add(1);
        res.add(prev);
        int n=2;
        while(n<=numRows){
            List<Integer> curr=new ArrayList<>();
            for(int i=0;i<n;i++){
                if(i==0 || i==n-1){
                    curr.add(prev.get(0));
                }
                else{
                    curr.add(prev.get(i-1)+prev.get(i));
                }
            }
            res.add(curr);
            prev=curr;
            n++;
        }
        return res;
    }
}