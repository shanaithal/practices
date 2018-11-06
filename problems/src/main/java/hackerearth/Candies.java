package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.io.OutputWriter;

import java.io.IOException;
import java.util.Arrays;

/**
 * You are given a string S consisting of lowercase English letters denoting different types of
 * candies. A substring of a string S is a string S' that occurs in S. For example, "bam" is a
 * substring of "babammm". Each candy costs 1 unit. You can pick some continuous candies such that
 * you can create a palindrome of length K by using some or all picked candies. Your task is to find
 * the minimum cost to create a palindrome of length K.
 *
 * <p>Input Format:
 *
 * <p>First line contains string S.
 *
 * <p>Next line contains an integer T denoting the number of test cases.
 *
 * <p>Next T lines contain a single integer K.
 *
 * <p>Output Format:
 *
 * <p>For each test case, print minimum cost as mentioned above. If you cannot create a palindrome
 * of length K then, simply print -1.
 *
 * <p>Constraints:
 *
 * <p>1 <= |S| <=10 power 5
 *
 * <p>1 <= T <= 10
 *
 * <p>1 <= K <= 10 power 5
 *
 * <p>Explanation
 *
 * <p>Test Case 1: You can pick candies denoted by "mm" and create a palindrome of size 2. So the
 * cost will be 2 units.
 *
 * <p>Test Case 2: You can pick candies denoted by "babam" and rearrange them, "bamab", to create a
 * palindrome of size 5. So the cost will be 5 units.
 */
public class Candies {

  private static int NO_OF_CHARS = 256;
  private final InputReader inputReader;

  private final OutputWriter outputWriter;

  public Candies(InputReader inputReader, OutputWriter outputWriter) {

    this.inputReader = inputReader;
    this.outputWriter = outputWriter;
  }

  static boolean canFormPalindrome(String str) {

    int count[] = new int[NO_OF_CHARS];
    Arrays.fill(count, 0);

    for (int i = 0; i < str.length(); i++) count[(int) (str.charAt(i))]++;

    int odd = 0;
    for (int i = 0; i < NO_OF_CHARS; i++) {
      if ((count[i] & 1) == 1) {

        odd++;
      }
      if (odd > 1) {

        return false;
      }
    }

    return true;
  }

  public int calculate() throws IOException {

    String string = "";
    char character;
    do {

      character = inputReader.nextChar();
      string += String.valueOf(character);
    } while (!inputReader.isWhiteSpace(character));

    int numberOfTestCases = inputReader.nextInt();
    int count = -1;
    while (numberOfTestCases-- > 0) {

      int subStringSize = inputReader.nextInt();
      count = -1;
      for (int index = 0; index < string.length() - subStringSize; index++) {

        String substring = string.substring(index, index + subStringSize);
        if (canFormPalindrome(substring)) {

          count = subStringSize;
        }
      }
      if (outputWriter != null) {

        outputWriter.println(count);
      }
    }

    return count;
  }
}
