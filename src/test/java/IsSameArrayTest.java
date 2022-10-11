import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class IsSameArrayTest {

    @Test
    void isSameArray() {
        Integer[] array1 = {1, 2, 3};
        Integer[] array2 = {1, 2, 4};
        boolean actual1 = IsSameArray.isSameArray(array1, array2);
        assertFalse(actual1);

        Integer[] array3 = {1, 2, 5};
        Integer[][] array4 = {array1, array2};
        Integer[][] array5 = {array1, array3};
        boolean actual2 = IsSameArray.isSameArray(array4, array5);
        assertFalse(actual2);
    }
}