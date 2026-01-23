class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        DisjointSet ds=new DisjointSet(n);
        int[] res=new int[2];
        for(int[] e:edges){
            if(!ds.unionByRank(e[0],e[1])){
                res=e;
            }
        }
        return res;
    }
}
class DisjointSet{
    ArrayList<Integer> size=new ArrayList<>();
    ArrayList<Integer> parent=new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int findUPar(int node){
        if(parent.get(node)==node){
            return node;
        }
        parent.set(node,findUPar(parent.get(node)));
        return parent.get(node);
    }
    public boolean unionByRank(int u,int v){
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        if(ulp_u==ulp_v)return false;
        if(size.get(ulp_u)>size.get(ulp_v)){
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
        else{
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
        return true;
    }
}