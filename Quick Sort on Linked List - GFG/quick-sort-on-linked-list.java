//{ Driver Code Starts
import java.util.*;
import java.lang.*;

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

class SortLL
{
    static Node head;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0) 
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);
            
            for(int i = 1; i< n; i++)
            {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }
            
            GfG gfg = new GfG();
            Node node = gfg.quickSort(head);
            
            printList(node);
            System.out.println();
        }
    }
    public static void printList(Node head)
    {
        while(head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    
    public static void addToTheLast(Node node) 
{
  if (head == null) 
  {
    head = node;
  } else 
  {
   Node temp = head;
   while (temp.next != null)
          temp = temp.next;
         temp.next = node;
  }
}
}
// } Driver Code Ends
/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
    
}*/
// you have to complete this function
class GfG
{
    public static Node quickSort(Node node)
    {
        if(node==null || node.next==null){
            return node;
        }
        Node start=node;
        Node end=node;
        while(end.next!=null){
            end=end.next;
        }
        sort(start,end);
        return node;
    } 
    public static void sort(Node start,Node end){
        if(start==end){
            return;
        }
        Node prev=partition(start,end);
        sort(start,prev);
        sort(prev.next,end);
    }
    public static Node partition(Node start,Node end){
        int pivot=end.data;
        Node current=start;
        Node prev=start;
        while(start!=end){
            if(start.data<pivot){
                prev=current;
                int temp=current.data;
                current.data=start.data;
                start.data=temp;
                current=current.next;
            }
            start=start.next;
        }
        int temp=end.data;
        end.data=current.data;
        current.data=temp;
        return prev;
    }
}

 
 
 
 
 
 
 
 
 
 
 
 
 