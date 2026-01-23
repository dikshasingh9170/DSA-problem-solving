class Solution {
    public int largestComponentSize(int[] nums) {
        int max=0;
        for(int i:nums){
            max=Math.max(i,max);
        }
        DSU dsu=new DSU(max+1);
        for(int i:nums){
            for(int j=2;j*j<=i;j++){
                if(i%j==0){
                    dsu.union(j,i);
                    dsu.union(i/j,i);
                }
            }
        }
        int ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            int root=dsu.find(num);
            map.put(root,map.getOrDefault(root,0)+1);
            ans=Math.max(ans,map.get(root));
        }
        return ans;
    }
}
class DSU {
    int[] parent;

    DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            parent[px] = py;
        }
    }
}