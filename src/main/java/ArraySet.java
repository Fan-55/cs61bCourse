import java.util.Iterator;

public class ArraySet<T> implements Iterable<T> {
    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("You can't add null to an ArraySet");
        }
        if (contains(x)) {
            return;
        }
        items[size] = x;
        size++;
    }

    public boolean contains(T x) {
        for (int i = 0; i < size; i++) {
//            if (items[i] == null) {
//                if (x == null) {
//                    return true;
//                }
//            } else if (items[i].equals(x)) {
//                return true;
//            }
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T> {
        private int wizPos;

        public ArraySetIterator() {
            this.wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        @Override
        public T next() {
            T returnItem = items[wizPos];
            wizPos++;
            return returnItem;
        }
    }

    public static void main(String[] args) {
//        ArraySet<String> s = new ArraySet<>();
//        s.add("horse");
//        s.add("fish");
//        s.add("house");
//        s.add("fish");
//        System.out.println(s.contains("horse"));
//        System.out.println(s.size());

        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);

        /* under the hood of enhanced for loop */
        Iterator<Integer> aseer = aset.iterator();
        while (aseer.hasNext()) {
            int i = aseer.next();
            System.out.println(i);
        }

        /**
         * To use enhanced for loop, the ArraySet has to implement Iterable interface so that java knows
         * the class's instance has iterator method
         */
        for (int i : aset) {
            System.out.println(i);
        }
    }
}
