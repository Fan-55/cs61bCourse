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

    @Override
    public String toString() {
        StringBuilder returnSB = new StringBuilder("{");
        for (int i = 0; i < size - 1; i++) {
            returnSB.append(items[i].toString());
            returnSB.append(", ");
        }
        returnSB.append(items[size - 1]);
        returnSB.append("}");
        return returnSB.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof ArraySet oas) {
            // check sets are of the same size
            if (oas.size != this.size) {
                return false;
            }
            // check that all my items are in the other array set
            for (T x : this) {
                if (!oas.contains(x)) {
                    return false;
                }
            }
            return true;
        }
        return false;
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
        ArraySet<Integer> aset2 = new ArraySet<>();
        aset2.add(5);
        aset2.add(23);
        aset2.add(42);

        System.out.println(aset.equals(aset2));

        System.out.println(aset.toString());

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
