
class LRUCache {
    class Node {
        int key, val;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            val = v;
        }
    }

    int capacity;
    int size;
    HashMap<Integer, Node> mp;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        mp = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)) return -1;

        Node curr = mp.get(key);

        remove(curr);

        insertToHead(curr);

        return curr.val;

    }
    
    public void put(int key, int value) {
        // if exists then update then put it front;
        // if not exits then insert and if size greater then capacity then remove tail;

        if(mp.containsKey(key)){
            Node curr = mp.get(key);
            curr.val = value;
            remove(curr);
            insertToHead(curr);
        }else{
            Node curr = new Node(key,value);
            mp.put(key,curr);
            insertToHead(curr);
            size++;
            if(size > capacity){
                mp.remove(tail.prev.key);
                remove(tail.prev);
                size--;
            }
        }
    }

    void remove(Node root){
        root.prev.next = root.next;
        root.next.prev = root.prev;
    }

    void insertToHead(Node node){
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}
