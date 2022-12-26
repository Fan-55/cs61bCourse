public class ArraySet<T> {
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

    public static void main(String[] args) {
        ArraySet<String> s = new ArraySet<>();
        s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");
        System.out.println(s.contains("horse"));
        System.out.println(s.size());
    }
}
