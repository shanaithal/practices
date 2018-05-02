package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.io.OutputWriter;

import java.io.IOException;

/**
 * You have been given two strings, A and B (of length N each) and Q queries. The strings contain
 * only 0s and/or 1s.
 *
 * <p>For every query, you are given an index i. You have to update the value at index i to 1 in
 * string B and check if B is lexicographically equal to or larger than A or not. If yes, then print
 * "YES" and if not, print "NO"
 *
 * <p>(without quotes).
 *
 * <p>Input format
 *
 * <p>First line contains two space-separated integers N and Q. Next line contains the string A.
 * Next line contains the string B. Next Q lines contains an integer i (1 - based indexing)
 *
 * <p>Output Format
 *
 * <p>For each query, print the desired output in a new line.
 *
 * <p>Input Constraints 1<=N, Q<= 10 power 6 1<=i<=N
 *
 * <p>Explanation
 *
 * <p>After 1st query: B = 10010. B < A. (NO) After 2nd query: B = 11010. B < A. (NO) After 3rd
 * query: B = 11110. B < A. (NO) After 4th query: B = 11110. B < A. (NO) After 5th query: B = 11111.
 * B = A. (YES)
 */
public class CompareStrings {

  private final InputReader inputReader;

  private final OutputWriter outputWriter;

  public CompareStrings(InputReader inputReader, OutputWriter outputWriter) {

    this.inputReader = inputReader;
    this.outputWriter = outputWriter;
  }

  public void calculate() throws IOException {

    //    Scanner inputReader = new Scanner(System.in);

    int binStringLength = inputReader.nextInt();
    int indexesToUpdate = inputReader.nextInt();
    StringBuilder stringA = new StringBuilder(String.valueOf(inputReader.nextInt()));
    if (stringA.length() < binStringLength) {

      stringA.reverse();
      int loopIndex = binStringLength - stringA.length();
      while (loopIndex-- > 0) {

        stringA.append("0");
      }
      stringA.reverse();
    }
    StringBuilder stringB = new StringBuilder(String.valueOf(inputReader.nextInt()));
    if (stringB.length() < binStringLength) {

      stringB.reverse();
      int loopIndex = binStringLength - stringB.length();
      while (loopIndex-- > 0) {

        stringB.append("0");
      }
      stringB.reverse();
    }

    while (indexesToUpdate-- > 0) {

      int indexToUpdate = inputReader.nextInt() - 1;
      stringB.replace(indexToUpdate, indexToUpdate + 1, "1");

      if (stringA.toString().compareTo(stringB.toString()) > 0) {

        System.out.println("NO");
      } else {

        System.out.println("YES");
      }
    }
  }
}
