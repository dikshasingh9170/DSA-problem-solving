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
    int preIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return solution(preorder,inorder,0,inorder.length-1,hm);
    }
    public TreeNode solution(int[] preorder, int[] inorder,int inStart,int inEnd,HashMap<Integer,Integer> hm){
        if(inStart>inEnd){
            return null;
        }
        int rootValue=preorder[preIndex++];
        TreeNode root=new TreeNode(rootValue);
        int inIndex=hm.get(rootValue);
        root.left=solution(preorder,inorder,inStart,inIndex-1,hm);
        root.right=solution(preorder,inorder,inIndex+1,inEnd,hm);
        return root;
    }
}