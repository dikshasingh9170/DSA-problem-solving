//{ Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}


class GfG
{
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {   
            int N = sc.nextInt();
            
            Node []a = new Node[N];
            
            for(int i = 0; i < N; i++)
            {
                int n = sc.nextInt();
                
                Node head = new Node(sc.nextInt());
                Node tail = head;
                
                for(int j=0; j<n-1; j++)
                {
                    tail.next = new Node(sc.nextInt());
                    tail = tail.next;
                }
                
                a[i] = head;
            }
            
            Solution g = new Solution();
             
            Node res = g.mergeKList(a,N);
            if(res!=null)
                printList(res);
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

// a is an array of Nodes of the heads of linked lists
// and N is size of array a


class Solution
{
    Node mergeKList(Node[]arr,int K)
    {
        if(K == 0) return null;
        if(K == 1) return arr[0];
        Node h = mergeSorted(arr[0],arr[1]);
        for(int i=2;i<arr.length;i++)
        {
            h = mergeSorted(h,arr[i]);
            
        }
        return h;
    }
    Node mergeSorted(Node a,Node b){
        Node temp=new Node(0);
        Node res=temp;
        while(a!=null && b!=null){
            if(a.data<b.data){
                temp.next=a;
                temp=temp.next;
                a=a.next;
            }
            else{
                temp.next=b;
                temp=temp.next;
                b=b.next;
            }
        }
        if(a!=null){
            temp.next=a;
        }
        else{
            temp.next=b;
        }
        return res.next;
    }
}
