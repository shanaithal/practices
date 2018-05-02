package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.io.OutputWriter;
import hackerearth.util.FileUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.fail;

public class MayEasy18BlotSpeedTest {

  @Test
  public void testCalculate() {

    try {

      InputReader inputReader =
          new InputReader(
              FileUtil.fetchFileContentAsStream("./src/test/resources/may_easy18_bolt_speed.txt"));
      Assert.assertEquals(MayEasy18BlotSpeed.RAHUL_WINS, getMayEasy18BlotSpeed(inputReader).calculate());
    } catch (IOException e) {

      fail(e.getMessage());
    }
  }

  private MayEasy18BlotSpeed getMayEasy18BlotSpeed(InputReader inputReader)
      throws UnsupportedEncodingException {
    return new MayEasy18BlotSpeed(inputReader, new OutputWriter());
  }
}
