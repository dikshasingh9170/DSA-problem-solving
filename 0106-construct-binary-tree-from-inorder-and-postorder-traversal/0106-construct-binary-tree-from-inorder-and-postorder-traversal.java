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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null || inorder.length!=postorder.length){
            return null;
        }
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return helper(hm,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    public TreeNode helper(HashMap<Integer,Integer> hm,int[] postorder,int istart,int iend,int pstart,int pend){
        if(pstart>pend || istart>iend){
            return null;
        }
        TreeNode root=new TreeNode(postorder[pend]);
        int mid=hm.get(postorder[pend]);
        root.left=helper(hm,postorder,istart,mid-1,pstart,pstart+mid-1-istart);
        root.right=helper(hm,postorder,mid+1,iend,pstart+mid-istart,pend-1);
        return root;
    }
}