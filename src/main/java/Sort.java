public class Sort {
    public static void sort(String[] x) {
        sort(x, 0);
    }

    public static void sort(String[] x, int start) {
        // find the smallest item
        // move it to the front
        // selection sort the rest (using recursion?)
        int smallestIndex = findSmallest(x, start);
        if (start == x.length) {
            return;
        }
        swap(x, start, smallestIndex);
        sort(x, start + 1);
    }

    public static void swap(String[] x, int a, int b) {
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }

    public static int findSmallest(String[] x, int start) {
        int smallestIndex = start;
        for (int i = start; i < x.length; i++) {
            int comparison = x[i].compareTo(x[smallestIndex]);
            if (comparison < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
}
