public class Maximizer {
    public static Comparable max(Comparable[] items) {
        int maxItemIndex = 0;
        for (int i = 0; i < items.length; i++) {
            int comparisonResult = items[i].compareTo(items[maxItemIndex]);
            if (comparisonResult > 0) {
                maxItemIndex = i;
            }
        }
        return items[maxItemIndex];
    }
}
