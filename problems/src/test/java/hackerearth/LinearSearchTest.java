package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.util.FileUtil;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class LinearSearchTest {

    @Test
    public void testCalculate() {

        try {

            InputReader inputReader =
                    new InputReader(
                            FileUtil.fetchFileContentAsStream("./src/test/resources/linear_search.txt"));
            assertEquals(2, getLinearSearch(inputReader).calculate());
        } catch (IOException e) {

            fail(e.getMessage());
        }
    }

    private LinearSearch getLinearSearch(InputReader inputReader) {
        return new LinearSearch(inputReader, null);
    }
}
