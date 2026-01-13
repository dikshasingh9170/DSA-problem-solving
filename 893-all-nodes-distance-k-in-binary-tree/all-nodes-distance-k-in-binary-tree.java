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
        HashMap<TreeNode,TreeNode> hm=new HashMap<>();
        markParent(root,hm);int i=0;
        Queue<TreeNode> q=new LinkedList<>();
        HashMap<TreeNode,Boolean> vis=new HashMap<>();
        List<Integer> res=new ArrayList<>();
        q.offer(target);
        vis.put(target,true);
        while(!q.isEmpty()){
            int size=q.size();
            if(i==k)break;
            while(size-->0){
                TreeNode x=q.poll();
                if(x.left!=null && !vis.containsKey(x.left)){
                    q.offer(x.left);
                    vis.put(x.left,true);
                }
                if(x.right!=null && !vis.containsKey(x.right)){
                    q.offer(x.right);
                    vis.put(x.right,true);
                }
                if(hm.containsKey(x) && !vis.containsKey(hm.get(x))){
                    q.offer(hm.get(x));
                    vis.put(hm.get(x),true);
                }
            }
            i++;
        }
        while(!q.isEmpty()){
            res.add(q.poll().val);
        }
        return res;
    }
    public void markParent(TreeNode root,HashMap<TreeNode,TreeNode> hm){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode x=q.poll();
            if(x.left!=null){
                hm.put(x.left,x);
                q.offer(x.left);
            }
            if(x.right!=null){
                hm.put(x.right,x);
                q.offer(x.right);
            }
        }
    }
}