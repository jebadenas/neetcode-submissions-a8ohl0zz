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

 //put first nodes in heap and just iterate through until heap is empty?

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0){
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);

        for (ListNode node: lists){
            minHeap.offer(node);
        }

        ListNode res = new ListNode();
        ListNode cur = res;

        while (!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            cur.next = node;
            cur = cur.next;

            node = node.next;
            if(node != null){
                minHeap.offer(node);
            }
        }

        return res.next;
    }
}
