package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.util.FileUtil;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MonkTakesAWalkTest {

    @Test
    public void testCalculate() {

        try {

            InputReader inputReader =
                    new InputReader(
                            FileUtil.fetchFileContentAsStream("./src/test/resources/monk_takes_a_walk.txt"));
            assertEquals(1, getMonkTakesAWalk(inputReader).calculate());
        } catch (IOException e) {

            fail(e.getMessage());
        }
    }

    private MonkTakesAWalk getMonkTakesAWalk(InputReader inputReader) {

        return new MonkTakesAWalk(inputReader, null);
    }
}
