package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.io.OutputWriter;
import hackerearth.util.FileUtil;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.fail;

/** @author I311197 */
public class CompareStringsTest {

  @Test
  public void testCalculate() {

    try {

      InputReader inputReader =
          new InputReader(
              FileUtil.fetchFileContentAsStream("./src/test/resources/compare_strings.txt"));
      new CompareStrings(inputReader, new OutputWriter()).calculate();
    } catch (IOException e) {

      fail(e.getMessage());
    }
  }
}
