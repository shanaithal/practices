package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.io.OutputWriter;

import java.io.IOException;
import java.util.HashSet;

/**
 * Little Shino loves maths. Today her teacher gave her two factors. Shino is now wondering how many
 * factors can divide both the numbers. She is busy with her assignments. Help her to solve the
 * problem.
 *
 * <p>Input: First line of the input file contains two factors, a and b.
 *
 * <p>Output: Print the number of common factors of a and b.
 *
 * <p>Constraints: 1<=a,b<=10 power 12
 */
public class LittleShinoAndCommonFactors {

  private final InputReader inputReader;
  private final OutputWriter outputWriter;
  private final HashSet<Integer> factors;

  public LittleShinoAndCommonFactors(InputReader inputReader, OutputWriter outputWriter) {

    this.inputReader = inputReader;
    this.outputWriter = outputWriter;
    factors = new HashSet<>(1);
  }

  static int gcd(int a, int b) {
    if (a == 0) return b;

    return gcd(b % a, a);
  }

  public int calculate() throws IOException {

    int numberOfCommonFactors = commDiv(inputReader.nextInt(), inputReader.nextInt());
    if (outputWriter != null) {

      outputWriter.println(numberOfCommonFactors);
    }

    return numberOfCommonFactors;
  }

  int commDiv(int a, int b) {

    int n = gcd(a, b);

    int result = 0;
    for (int i = 1; i <= Math.sqrt(n); i++) {

      if (n % i == 0) {

        if (n / i == i) {

          result += 1;
        } else {

          result += 2;
        }
      }
    }

    return result;
  }
}
