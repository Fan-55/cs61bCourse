public class VengefulSLList<Item> extends SLList<Item> {
    private SLList<Item> deletedItems;

    public VengefulSLList() {
        super();
        deletedItems = new SLList<>();
    }

    public void printLostItems() {
        for (int i = 0; i < deletedItems.size(); i++) {
            System.out.println(deletedItems.get(i) + " ");
        }
    }

    @Override
    public Item removeLast() {
        Item x = super.removeLast();
        deletedItems.addLast(x);
        return x;
    }

    public static void main(String[] args) {
        VengefulSLList<Integer> vs1 = new VengefulSLList<>();
        vs1.addLast(1);
        vs1.addLast(5);
        vs1.addLast(10);
        vs1.addLast(13);
        // [1, 5, 10, 13]

        vs1.removeLast();
        vs1.removeLast();
        // [1, 5]

        System.out.println("The fallen are: ");
        vs1.printLostItems();
    }
}
