public interface List61B<Item> {
    public void addLast(Item x);

    public void addFirst(Item x);

    public Item getLast();

    public int size();

    public Item get(int i);

    public Item removeLast();

    default public void print() {
        for (int i = 0; i < size(); i += 1) {
            System.out.print(get(i) + " ");
        }
    }
}
