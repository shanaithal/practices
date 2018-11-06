package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.io.OutputWriter;
import hackerearth.util.FileUtil;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.fail;

/** @author I311197 */
public class PoisonousGasTest {

  @Test
  public void testCalculate() {

    try {

      InputReader inputReader =
          new InputReader(
              FileUtil.fetchFileContentAsStream("./src/test/resources/poisonous_gas.txt"));
      getPoisonousGas(inputReader).calculate();
    } catch (IOException e) {

      fail(e.getMessage());
    }
  }

  private PoisonousGas getPoisonousGas(InputReader inputReader)
      throws UnsupportedEncodingException {
    return new PoisonousGas(inputReader, new OutputWriter());
  }
}
