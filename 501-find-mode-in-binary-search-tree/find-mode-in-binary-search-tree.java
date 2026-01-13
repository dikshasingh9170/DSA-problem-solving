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
    Integer max = 0;
    int count=0;
    int maxCount=0;

    public int[] findMode(TreeNode root) {
        max=0;
        List<Integer> list = new ArrayList<>();
        helper(root,list);

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void helper(TreeNode root,List<Integer> list) {
        if(root.left!=null){
            helper(root.left,list);
        }
        if(max==null || root.val!=max){
            count=1;
        }
        else{
            count++;
        }

        if(count>maxCount){
            maxCount=count;
            list.clear();
            list.add(root.val);
        }else if(count==maxCount){
            list.add(root.val);
        }
        max=root.val;
        if(root.right!=null){
            helper(root.right,list);
        }
    }
}
