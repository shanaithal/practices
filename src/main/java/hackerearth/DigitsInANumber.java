package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.io.OutputWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * Let's say 1, 2, 3 are the only digits which exists in a unique number system, so the numbers will
 * be 1, 2 3,11, 12,13,21...
 *
 * <p>in ascending order .
 *
 * <p>1st number is 1 and number of digits is 1
 *
 * <p>4th will be 11
 *
 * <p>and number of digits is 2
 *
 * <p>14th will be 112
 *
 * <p>and number of digits will be 3
 *
 * <p>40th will be 1111
 *
 * <p>and number of digits will be 4
 *
 * <p>You have to find number of digits of
 *
 * <p>term in unique number system .
 *
 * <p>Input :
 *
 * <p>First line T contains number of testcases
 *
 * <p>Next T lines contains N
 *
 * <p>Output :
 *
 * <p>Number of digits in
 *
 * <p>number
 *
 * <p>Constraints
 *
 * <p>1<=T<=10 power 5
 *
 * <p>1<=N<=10 power 18
 *
 * <p>Explanation
 *
 * <p>1st number is 1 and number of digits is 1
 *
 * <p>4th will be 11
 *
 * <p>and number of digits is 2
 *
 * <p>14th will be 112
 *
 * <p>and number of digits will be 3
 *
 * <p>40th will be 1111 and number of digits will be 4
 */
public class DigitsInANumber {

  private final InputReader inputReader;

  private final OutputWriter outputWriter;

  public DigitsInANumber(InputReader inputReader, OutputWriter outputWriter) {

    this.inputReader = inputReader;
    this.outputWriter = outputWriter;
  }

  // Use BigInteger for 18 digit integer inputs
  public void calculate() throws IOException {

    LinkedHashSet<Integer> numbers = new LinkedHashSet<>(1);
    Integer seed = 0;
    int numberOfTestCases = inputReader.nextInt();
    while (numberOfTestCases-- > 0) {

      Integer nthNumber = inputReader.nextInt();
      while (numbers.size() < nthNumber) {

        if (String.valueOf(seed).matches("[123]*")) {

          numbers.add(seed);
        }
        seed++;
      }

      if (outputWriter != null) {

        outputWriter.println(
            String.valueOf(new ArrayList<>(numbers).get(nthNumber - 1).intValue()).length());
      }
    }
  }
}
