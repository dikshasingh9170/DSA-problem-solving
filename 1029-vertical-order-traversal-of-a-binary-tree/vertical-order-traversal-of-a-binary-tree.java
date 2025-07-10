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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
       TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> tm=new TreeMap<>();
       List<List<Integer>> res=new ArrayList<>();
       Queue<Tuple> q=new LinkedList<Tuple>();
       q.offer(new Tuple(root,0,0));
       while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                TreeNode x=q.peek().root;
                int row=q.peek().row;
                int col=q.peek().col;
                q.poll();
                if(!tm.containsKey(row)){
                    tm.put(row,new TreeMap<>());
                }
                if(!tm.get(row).containsKey(col)){
                    tm.get(row).put(col,new PriorityQueue<>());
                }
                tm.get(row).get(col).offer(x.val);
                if(x.left!=null){
                    q.offer(new Tuple(x.left,row-1,col+1));
                }
                if(x.right!=null){
                    q.offer(new Tuple(x.right,row+1,col+1));
                }
            }
       }
       for(TreeMap<Integer,PriorityQueue<Integer>> ys:tm.values()){
            ArrayList<Integer> arr=new ArrayList<>();
            for(PriorityQueue<Integer> pq:ys.values()){
                while(!pq.isEmpty()){
                    arr.add(pq.poll());
                }
            }
            res.add(arr);
       }
       return res;
    }
    
}
class Tuple{
    TreeNode root;
    int row;
    int col;
    public Tuple(TreeNode root,int row,int col){
        this.root=root;
        this.row=row;
        this.col=col;
    }
}
