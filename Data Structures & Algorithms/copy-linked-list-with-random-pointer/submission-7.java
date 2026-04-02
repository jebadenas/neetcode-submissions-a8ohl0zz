/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        
        //have hashmap that maps the old node to new node
        // use hashmap to modify next and random value of new nodes

        Map<Node, Node> oldToNew = new HashMap<>();
        oldToNew.put(null,null);

        Node cur = head;
        while (cur != null){
            Node newNode = new Node(cur.val);
            oldToNew.put(cur, newNode);
            cur = cur.next;
        }

        cur = head;

        while (cur != null){
            Node newNode = oldToNew.get(cur);
            newNode.next = oldToNew.get(cur.next);
            newNode.random = oldToNew.get(cur.random);
            cur = cur.next;
        }

       

        return oldToNew.get(head);
    }
}
