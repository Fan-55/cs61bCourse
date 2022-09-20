import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {
    @Test
    void sort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};
        Sort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void findSmallest() {
        String[] input1 = {"i", "have", "an", "egg"};
        int actual1 = Sort.findSmallest(input1, 0);
        int expected1 = 2;
        assertEquals(expected1, actual1);

        String[] input2 = {"there", "are", "many", "pigs"};
        int actual2 = Sort.findSmallest(input2, 2);
        int expected2 = 2;
        assertEquals(expected2, actual2);
    }

    @Test
    void swap() {
        String[] input = {"i", "have", "an", "egg"};
        int a = 0;
        int b = 2;
        String[] expected = {"an", "have", "i", "egg"};
        Sort.swap(input, a, b);
        assertArrayEquals(expected, input);
    }
}