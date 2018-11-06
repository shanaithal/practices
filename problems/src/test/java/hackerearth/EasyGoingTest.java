package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.util.FileUtil;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/** @author I311197 */
public class EasyGoingTest {

  @Test
  public void testCalculate() {

    try {

      InputReader inputReader =
          new InputReader(FileUtil.fetchFileContentAsStream("./src/test/resources/easy_going.txt"));
      assertEquals(5834, getEasyGoing(inputReader).calculate());
    } catch (IOException e) {

      fail(e.getMessage());
    }
  }

  private EasyGoing getEasyGoing(InputReader inputReader) {
    return new EasyGoing(inputReader, null);
  }
}
