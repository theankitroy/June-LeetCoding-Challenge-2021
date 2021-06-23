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
   public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode currL = dummy;
        ListNode prevL = null;
        for(int i = 0; i < left; i++) {
            prevL = currL;
            currL = currL.next;
        }
        
        ListNode prevR = prevL;
        ListNode currR = currL;
        for(int i = left; i <= right; i++) {
            ListNode next = currR.next;
            currR.next = prevR;
            prevR = currR;
            currR = next;
        }
        
        prevL.next = prevR;
        currL.next = currR;
        
        return dummy.next;
    }
}
