package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.util.ArrayUtil;
import hackerearth.util.FileUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class SelectionSortTest {

    @Test
    public void testCalculate() {


        try {

            InputReader inputReader =
                    new InputReader(
                            FileUtil.fetchFileContentAsStream("./src/test/resources/selection_sort.txt"));

            List<Integer> sortedArray = getSelectionSort(inputReader).calculate();
            assertTrue(ArrayUtil.isSorted(sortedArray));
        } catch (IOException e) {

            fail(e.getMessage());
        }
    }

    private SelectionSort getSelectionSort(InputReader inputReader) {

        return new SelectionSort(inputReader);
    }
}