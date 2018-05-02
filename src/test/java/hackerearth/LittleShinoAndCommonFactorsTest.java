package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.io.OutputWriter;
import hackerearth.util.FileUtil;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class LittleShinoAndCommonFactorsTest {

  @Test
  public void testCalculate() {

    try {

      InputReader inputReader =
          new InputReader(
              FileUtil.fetchFileContentAsStream(
                  "./src/test/resources/little_shino_and_common_factors.txt"));
      assertEquals(8, getLittleShinoAndCommonFactors(inputReader).calculate());
    } catch (IOException e) {

      fail(e.getMessage());
    }
  }

  private LittleShinoAndCommonFactors getLittleShinoAndCommonFactors(InputReader inputReader)
      throws UnsupportedEncodingException {

    OutputWriter outputWriter = new OutputWriter();
    return new LittleShinoAndCommonFactors(inputReader, outputWriter);
  }
}
