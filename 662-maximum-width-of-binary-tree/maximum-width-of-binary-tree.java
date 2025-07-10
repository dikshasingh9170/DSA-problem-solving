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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        int max=Integer.MIN_VALUE;
        int size=0,start=0,end=0;
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            size=q.size();
            start=0;end=0;
            for(int i=0;i<size;i++){
                Pair x=q.poll();
                TreeNode r=x.root;
                int idx=x.index;
                if(i==0)start=idx;
                if(i==size-1)end=idx;
                if(r.left!=null){
                    q.offer(new Pair(r.left,2*idx));
                }
                if(r.right!=null){
                    q.offer(new Pair(r.right,2*idx+1));
                }
            }
            max=Math.max(max,end-start+1);
        }
        return max;
    }
}
class Pair{
    TreeNode root;
    int index;
    public Pair(TreeNode root,int index){
        this.root=root;
        this.index=index;
    }
}