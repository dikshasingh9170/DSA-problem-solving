/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        int c1=0;int c2=0;
        ListNode curr=head;
        while(curr!=null){
            curr=curr.next;
            c1++;
        }
        c1= (c1/2);
        while(c2<c1){
            head=head.next;
            c2++;
        }
        return head;
    }
}