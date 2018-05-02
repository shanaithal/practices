package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.io.OutputWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * */
public class FredoAndArrayUpdate {

  private final InputReader inputReader;

  private final OutputWriter outputWriter;

  public FredoAndArrayUpdate(InputReader inputReader, OutputWriter outputWriter) {

    this.inputReader = inputReader;
    this.outputWriter = outputWriter;
  }

  public int calculate() throws IOException {

    List<Integer> array = new ArrayList<>(1);
    int sum = 0;
    int arraySize = inputReader.nextInt();

    while (arraySize-- > 0) {

      int arrayElement = inputReader.nextInt();
      sum += arrayElement;
      array.add(arrayElement);
    }
    arraySize = array.size();

    int quotient = sum / arraySize;
    if (sum % arraySize == 0) {

      quotient += 1;
    } else {
      if (sum % arraySize < arraySize) {

        quotient +=1;
      } else {

        quotient +=2;
      }
    }
    if (outputWriter != null) {

      outputWriter.println(quotient);
    }

    return quotient;
  }
}
