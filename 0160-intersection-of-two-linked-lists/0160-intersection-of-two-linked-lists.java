/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0;      
        int sizeB = 0;      
        ListNode temp;
        for(temp = headA; temp != null; temp = temp.next)
        {
            sizeA++;            
        }
        for(temp = headB; temp != null; temp = temp.next)
        {
            sizeB++;         
        }
        while(sizeA > sizeB)
        {
            headA = headA.next;
            sizeA--;
        }
        while(sizeB > sizeA)
        {
            headB = headB.next;
            sizeB--;
        }
        while(headA != headB)
        {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;           
    }
}