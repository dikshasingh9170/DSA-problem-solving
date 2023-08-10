//{ Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}
// } Driver Code Ends


class Solution
{
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        return build(inorder,0,n-1,preorder,0,n-1);
    }
    public static Node build(int[] inorder,int istart,int iend,int[] preorder,int pstart,int pend){
        if(istart>iend || pstart>pend){
            return null;
        }
        Node root=new Node(preorder[pstart]);
        int ind=0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==preorder[pstart]){
                ind=i;
                inorder[i]=-1;
                break;
            }
        }
        int leftnum=ind-istart;
        root.left=build(inorder,istart,ind-1,preorder,pstart+1,pstart+leftnum);
        root.right=build(inorder,ind+1,iend,preorder,pstart+leftnum+1,pend);
        return root;
    }
}
