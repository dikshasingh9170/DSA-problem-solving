class Solution {
    public int findKthPositive(int[] arr, int k) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        HashSet<Integer> res1=new HashSet<Integer>();
        for(int i=0;i<arr.length;i++){
            res1.add(arr[i]);
        }
        for(int i=1;i<arr[arr.length-1];i++){
            if(res1.contains(i)){
                continue;
            }
            else{
                res.add(i);
            }
        }
        if(k>res.size()){
            int n=k-res.size();
            return arr[arr.length-1]+n;
        }
        else{
            return res.get(k-1);
        }
    }
}