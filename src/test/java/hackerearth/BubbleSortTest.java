package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.util.ArrayUtil;
import hackerearth.util.FileUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class BubbleSortTest {

    @Test
    public void testBubbleSort() {

        try {

            InputReader inputReader =
                    new InputReader(
                            FileUtil.fetchFileContentAsStream("./src/test/resources/bubble_sort.txt"));

            List<Integer> sortedArray = getBubbleSort(inputReader).calculate();
            assertTrue(ArrayUtil.isSorted(sortedArray));
        } catch (IOException e) {

            fail(e.getMessage());
        }
    }

    private BubbleSort getBubbleSort(InputReader inputReader) {

        return new BubbleSort(inputReader, null);
    }
}
