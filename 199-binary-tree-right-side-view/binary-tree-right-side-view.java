/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> arr=new ArrayList<Integer>();
        TreeMap<Integer,Integer> tm=new TreeMap<>();
        Queue<Pair> q=new LinkedList<Pair>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                TreeNode x=q.peek().root;
                int level=q.peek().col;
                q.poll();
                if(!tm.containsKey(level)){
                    tm.put(level,x.val);
                }
                if(x.right!=null){
                    q.offer(new Pair(x.right,level+1));
                }
                if(x.left!=null){
                    q.offer(new Pair(x.left,level+1));
                }
            }
        }
        for(Integer res:tm.values()){
            arr.add(res);
        }
        return arr;
    }
}
class Pair{
    TreeNode root;
    int col;
    public Pair(TreeNode root,int col){
        this.root=root;
        this.col=col;
    }
}