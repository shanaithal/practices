package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.io.OutputWriter;
import hackerearth.util.FileUtil;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.fail;

public class CandiesTest {

  @Test
  public void testCalculate() {

    try {

      InputReader inputReader =
          new InputReader(FileUtil.fetchFileContentAsStream("./src/test/resources/candies.txt"));
      getCandies(inputReader).calculate();
    } catch (IOException e) {

      fail(e.getMessage());
    }
  }

  private Candies getCandies(InputReader inputReader) throws UnsupportedEncodingException {
    return new Candies(inputReader, new OutputWriter());
  }
}
