package misc;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class AirplaneSeatingAlgorithmTest {

  @Test
  public void testCalculate() {

    try {

      AirplaneSeatingAlgorithm airplaneSeatingAlgorithm =
          new AirplaneSeatingAlgorithm(
              fetchFileContentAsStream(
                  "./src/test/resources/airplane_seating_algorithm_input.txt"));
      List<int[][]> calculatedResult = airplaneSeatingAlgorithm.calculate();
      StringBuilder assignedSeat = new StringBuilder();
      for (int[][] resultElement : calculatedResult) {

        assignedSeat.append(Arrays.deepToString(resultElement));
      }
      Assert.assertEquals(
          assignedSeat.toString(),
          fetchFileContentAsString(
              "./src/test/resources/expected_airplane_seating_algorithm_output.txt"));
    } catch (IOException e) {

      Assert.fail(e.getMessage());
    }
  }

  InputStream fetchFileContentAsStream(String filePath) throws IOException {

    File file = new File(filePath);

    return new FileInputStream(file);
  }

  String fetchFileContentAsString(String filePath) throws IOException {

    return IOUtils.toString(fetchFileContentAsStream(filePath), "UTF-8");
  }
}
