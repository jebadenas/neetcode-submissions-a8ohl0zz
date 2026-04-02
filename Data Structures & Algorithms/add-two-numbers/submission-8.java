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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        int carry = 0;

        while (l1!= null || l2 != null | carry != 0){
            int l1Val = (l1 != null) ? l1.val : 0;
            int l2Val = (l2 != null) ? l2.val : 0;

            int val = (l1Val + l2Val + carry)%10;
            carry = (l1Val + l2Val + carry)/10;

            ListNode newNode = new ListNode(val);
            cur.next = newNode;
            cur = cur.next;

            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;

        }
        

        return dummy.next;
    }
}
