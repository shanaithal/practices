package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.io.OutputWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinearSearch {

  private final InputReader inputReader;
  private final OutputWriter outputWriter;

  public LinearSearch(InputReader inputReader, OutputWriter outputWriter) {

    this.inputReader = inputReader;
    this.outputWriter = outputWriter;
  }

  public int calculate() throws IOException {

    int sizeOfArray = inputReader.nextInt();
    int searchInt = inputReader.nextInt();
    int lastIndex = -1;

    List<Integer> array = new ArrayList<>(1);

    while (sizeOfArray-- > 0) {

      array.add(inputReader.nextInt());
      if (array.contains(searchInt)) {

        lastIndex = array.lastIndexOf(searchInt) + 1;
      }
    }

    if (lastIndex > -1) {

      if (outputWriter != null) {

        outputWriter.println(lastIndex);
      }
    }

    return lastIndex;
  }
}
