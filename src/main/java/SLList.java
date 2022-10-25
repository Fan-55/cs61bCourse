public class SLList<Item> implements List61B<Item> {
    private class Node {
        public Item item;
        public Node next;

        public Node(Item i, Node n) {
            item = i;
            next = n;
        }
    }

    /// The first node (if it exists) is at sentinel.next
    private Node sentinel;

    /// caching way to get the size of SLList
    private int size;

    /// create empty SLList
    public SLList() {
        sentinel = new Node(null, null);
        size = 0;
    }

    public SLList(Item x) {
        sentinel = new Node(null, null);
        sentinel.next = new Node(x, null);
        size = 1;
    }

    @Override
    public void addLast(Item x) {
        Node p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node(x, null);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Item removeLast() {
        Node back = getLastNode();
        if (back == sentinel) {
            return null;
        }
        Node p = sentinel;
        while (p.next != back) {
            p = p.next;
        }
        p.next = null;
        return back.item;
    }

    private Node getLastNode() {
        Node p = sentinel;

        /* Move p until it reaches the end. */
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    @Override
    public Item get(int i) {
        return get(i, sentinel.next);
    }

    private Item get(int i, Node p) {
        if (i == 0) {
            return p.item;
        }
        return get(i - 1, p.next);
    }


    @Override
    public Item getLast() {
        Node back = getLastNode();
        return back.item;
    }

    @Override
    public void addFirst(Item x) {
        Node oldFrontNode = sentinel.next;
        Node newNode = new Node(x, oldFrontNode);
        sentinel.next = newNode;
        size += 1;
    }
}
