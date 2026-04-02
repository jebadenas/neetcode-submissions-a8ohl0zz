class Node {
    public int key;
    public int val;
    public Node prev;
    public Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0,0);
        
        this.right.prev = this.left;
        this.left.next = this.right;
    }

    public void remove(Node n){
        Node prev = n.prev;
        Node next = n.next;
        prev.next = next;
        next.prev = prev;
        cache.remove(n.key);
    }

    public void insert(Node n){
        Node prev = this.right.prev;
        prev.next = n;
        this.right.prev = n;
        n.prev = prev;
        n.next = this.right;
        cache.put(n.key, n);
    }


    public int get(int key) {
        if (cache.containsKey(key)){
            Node n = cache.get(key);
            remove(n);
            insert(n);
            return n.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)){
            Node n = cache.get(key);
            remove(n);
        }

        Node newNode = new Node(key,value);
        insert(newNode);

        if (cache.size() > this.capacity){
            remove(this.left.next);
        }
    }
}
