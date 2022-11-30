/**
 * items: [1, 2, 3, 50, 9, ...]
 * size: 5
 * invariants:
 * addLast: The added item should be at position size.
 * size: The size is the number of items in the list.
 * getLast: The last item is at position size - 1.
 */

public class AList<Item> {
    private Item[] items;
    private int size;

    /**
     * Creates an empty list.
     */
    public AList() {
        items = (Item[]) new Object[100];
        size = 0;
    }

    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /**
     * Inserts X into the back of the list.
     */
    public void addLast(Item x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size] = x;
        size++;
    }

    /**
     * Returns the item from the back of the list.
     */
    public Item getLast() {
        return items[size - 1];
    }

    /**
     * Gets the ith item in the list (0 is the front).
     */
    public Item get(int i) {
        return items[i];
    }

    /**
     * Returns the number of items in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Deletes item from back of the list and
     * returns deleted item.
     */
    public Item removeLast() {
        Item lastItem = getLast();
        items[size - 1] = null;
        size--;
        return lastItem;
    }
}