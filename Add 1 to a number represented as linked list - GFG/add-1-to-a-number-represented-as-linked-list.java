//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node addOne(Node head) 
    { 
        if(head==null){
            return head;
        }
        if(head.next==null){
            head.data+=1;
            return head;
        }
        Node rev=reverse(head);
        Node curr=rev;
        while(curr!=null){
            if(curr.data<9){
                curr.data+=1;
                return reverse(rev);
            }
            curr.data=0;
            curr=curr.next;
        }
        Node nnode=new Node(1);
        nnode.next=rev;
        return nnode;
    }
    public static Node reverse(Node head){
        Node prev=null;
        while(head!=null){
            Node next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}
