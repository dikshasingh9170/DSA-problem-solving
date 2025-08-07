/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parent=new HashMap<TreeNode,TreeNode>();
        markParent(root,parent);
        HashMap<TreeNode,Boolean> visited=new HashMap<TreeNode,Boolean>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(target);
        visited.put(target,true);
        int curr_count=0;
        while(!q.isEmpty()){
            if(curr_count==k)break;
            int size=q.size();
            while(size-->0){
                TreeNode x=q.poll();
                if(x.left!=null && visited.get(x.left)==null){
                    q.offer(x.left);
                    visited.put(x.left,true);
                }
                if(x.right!=null && visited.get(x.right)==null){
                    q.offer(x.right);
                    visited.put(x.right,true);
                }
                if(parent.get(x)!=null && visited.get(parent.get(x))==null){
                    q.offer(parent.get(x));
                    visited.put(parent.get(x),true);
                }
            }
            curr_count++;
        }
        List<Integer> res=new ArrayList<Integer>();
        while(!q.isEmpty()){
            res.add(q.poll().val);
        }
        return res;
    }
    public void markParent(TreeNode root,HashMap<TreeNode,TreeNode> parent){
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode x=q.poll();
            if(x.left!=null){
                q.offer(x.left);
                parent.put(x.left,x);
            }
            if(x.right!=null){
                q.offer(x.right);
                parent.put(x.right,x);
            }
        }
    }
}