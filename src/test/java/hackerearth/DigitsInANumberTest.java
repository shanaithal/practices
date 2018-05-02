package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.io.OutputWriter;
import hackerearth.util.FileUtil;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.fail;

public class DigitsInANumberTest {

  @Test
  public void calculate() {

    try {

      InputReader inputReader = new InputReader(FileUtil.fetchFileContentAsStream("./src/test/resources/digits_in_a_number.txt"));
      getDigitsInANumber(inputReader).calculate();
    } catch (IOException e) {

      fail(e.getMessage());
    }
  }

  private DigitsInANumber getDigitsInANumber(InputReader inputReader) throws UnsupportedEncodingException {

    return new DigitsInANumber(inputReader, new OutputWriter());
  }
}