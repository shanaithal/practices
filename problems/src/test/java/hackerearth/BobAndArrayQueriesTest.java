package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.io.OutputWriter;
import hackerearth.util.FileUtil;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/** @author I311197 */
public class BobAndArrayQueriesTest {

  @Test
  public void testCalculate() {

    try {

      InputReader inputReader =
          new InputReader(
              FileUtil.fetchFileContentAsStream("./src/test/resources/bob_and_array_queries.txt"));
      assertEquals(2, getBobAndArrayQueries(inputReader).calculate());
    } catch (IOException e) {

      fail(e.getMessage());
    }
  }

  private BobAndArrayQueries getBobAndArrayQueries(InputReader inputReader)
      throws UnsupportedEncodingException {
    return new BobAndArrayQueries(inputReader, new OutputWriter());
  }
}
