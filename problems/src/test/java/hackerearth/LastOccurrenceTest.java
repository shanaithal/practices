package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.util.FileUtil;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class LastOccurrenceTest {

    @Test
    public void testCalculate() {

        try {

            InputReader inputReader =
                    new InputReader(
                            FileUtil.fetchFileContentAsStream("./src/test/resources/last_occurrence.txt"));
            assertEquals(10000, getLastOccurrence(inputReader).calculate());
        } catch (IOException e) {

            fail(e.getMessage());
        }
    }

    private LastOccurrence getLastOccurrence(InputReader inputReader) {
        return new LastOccurrence(inputReader, null);
    }
}
