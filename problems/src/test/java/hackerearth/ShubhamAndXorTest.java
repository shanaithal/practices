package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.util.FileUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ShubhamAndXorTest {

    @Test
    public void testCalculate() {

        try {

            InputReader inputReader = new InputReader(FileUtil.fetchFileContentAsStream("./src/test/resources/shubham_and_xor.txt"));
            assertEquals(125, getShubhamAndXor(inputReader).calculate());
        } catch (Exception e) {

            fail(e.getMessage());
        }
    }

    private ShubhamAndXor getShubhamAndXor(InputReader inputReader) {
        return new ShubhamAndXor(inputReader, null);
    }
}
