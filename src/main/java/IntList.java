public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /// iterative way
    public int iterativeSize() {
        int size = 0;
        IntList p = rest;
        while (p != null) {
            size++;
            p = p.rest;
        }
        return size;
    }

    /// recursion way
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }
}
