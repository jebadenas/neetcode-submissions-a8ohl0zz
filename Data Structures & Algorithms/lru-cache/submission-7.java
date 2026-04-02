public class Node{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}


class LRUCache {
    private int cap;
    private HashMap<Integer, Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = right;
        this.right.prev = left;
    }

    public void remove(Node node){
        Node nxt = node.next;
        Node prev = node.prev;
        prev.next = nxt;
        nxt.prev = prev;
    }

    public void insert(Node node){
        Node l = right.prev;
        l.next = node;
        node.prev = l;
        right.prev = node;
        node.next = right;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)){
            Node node = cache.get(key);
            remove(cache.get(key));
            insert(node);

            return node.val;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)){
            remove(cache.get(key));
        }

        Node node = new Node(key, value);
        cache.put(key, node);
        insert(node);

        if (cache.size() > cap){
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
