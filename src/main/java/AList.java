/**
 * Invariants:
 * addLast: The item which is going to be added to the list will be at position size. E.g., The size is 4, and the new item
 * will be at 4th position.
 * size: The number of items in the list should be size.
 * getLast: The last item is at position (size - 1)
 */
public class AList<Item> implements List61B<Item> {
    private Item[] items;
    private int size;

    public AList() {
        items = (Item[]) new Object[100];
        size = 0;
    }

    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    @Override
    public void addLast(Item x) {
        if (size == items.length) {
            resize(size + 1);
        }
        items[size] = x;
        size += 1;
    }

    @Override
    public Item getLast() {
        return items[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Item get(int i) {
        return items[i];
    }

    /* Deletes the time from the back of the list and returns deleted item */
    public Item removeLast() {
        Item x = getLast();
        items[size - 1] = null;
        size -= 1;
        return x;
    }

    @Override
    public void addFirst(Item x) {
        insert(x, 0);
    }

    public void insert(Item x, int position) {
        Item[] newItems = (Item[]) new Object[items.length + 1];

        System.arraycopy(items, 0, newItems, 0, position);
        newItems[position] = x;

        System.arraycopy(items, position, newItems, position + 1, items.length - position);
        items = newItems;

        size += 1;
    }
}
