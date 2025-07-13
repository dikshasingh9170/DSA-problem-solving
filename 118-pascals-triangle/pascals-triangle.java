class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> arr,prev=null;
        for(int i=0;i<numRows;i++){
            arr=new ArrayList<Integer>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    arr.add(1);
                }else{
                    arr.add(prev.get(j-1)+prev.get(j));
                }
            }
            prev=arr;
            res.add(arr);
        }
        return res;
    }
}