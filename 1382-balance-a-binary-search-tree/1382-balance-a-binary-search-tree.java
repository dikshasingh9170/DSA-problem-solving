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
    public ArrayList<TreeNode> arr=new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return solve(arr,0,arr.size()-1);
    }
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        arr.add(root);
        inorder(root.right);
    }
    public TreeNode solve(ArrayList<TreeNode> arr,int start,int end){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        TreeNode root=arr.get(mid);
        root.left=solve(arr,start,mid-1);
        root.right=solve(arr,mid+1,end);
        return root;
    }
}