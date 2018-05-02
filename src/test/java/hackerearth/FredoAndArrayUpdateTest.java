package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.io.OutputWriter;
import hackerearth.util.FileUtil;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/** @author I311197 */
public class FredoAndArrayUpdateTest {

  @Test
  public void testCalculate() {

    try {

      InputReader inputReader =
          new InputReader(
              FileUtil.fetchFileContentAsStream("./src/test/resources/fredo_and_array_update.txt"));
      assertEquals(4, getFredoAndArrayUpdate(inputReader).calculate());
    } catch (IOException e) {

      fail(e.getMessage());
    }
  }

  private FredoAndArrayUpdate getFredoAndArrayUpdate(InputReader inputReader) throws IOException {
    return new FredoAndArrayUpdate(inputReader, new OutputWriter());
  }
}
