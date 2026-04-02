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
    public void reorderList(ListNode head) {
        // get first and second half
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast!= null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse second half
        ListNode second = slow.next; //current head of second half
        ListNode prev = null;
        slow.next = null; // slow points to the last node in the first half, break connection to second half here;

        while (second != null){
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        //merge two lists
    
        ListNode secondHead = prev;
        
        while (secondHead!= null){
            ListNode tmp1 = head.next;
            ListNode tmp2 = secondHead.next;

            head.next = secondHead;
            secondHead.next = tmp1;

            head = tmp1;
            secondHead = tmp2;
        }

        
        
    }
}
