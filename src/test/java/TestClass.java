import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestClass {

    @Test
    void testAscendingSort() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};

        for (int i = 0; i < arr.length - 1; i++) {
            Assertions.assertTrue(arr[i] >= arr[i + 1]);
        }
    }
}
