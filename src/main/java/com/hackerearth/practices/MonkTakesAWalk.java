package com.hackerearth.practices;

import java.io.IOException;

/**
 * Today, Monk went for a walk in a garden. There are many trees in the garden and each tree has an
 * English alphabet on it. While Monk was walking, he noticed that all trees with vowels on it are
 * not in good state. He decided to take care of them. So, he asked you to tell him the count of
 * such trees in the garden. Note : The following letters are vowels: 'A', 'E', 'I', 'O', 'U'
 * ,'a','e','i','o' and 'u'.
 *
 * <p>Input: The first line consists of an integer T denoting the number of test cases. Each test
 * case consists of only one string, each character of string denoting the alphabet (may be
 * lowercase or uppercase) on a tree in the garden.
 *
 * <p>Output: For each test case, print the count in a new line.
 */
class MonkTakesAWalk {

  private static InputReader inputReader;
  private static OutputWriter outputWriter;

  public MonkTakesAWalk(InputReader inputReader, OutputWriter outputWriter) {

    MonkTakesAWalk.inputReader = inputReader;
    MonkTakesAWalk.outputWriter = outputWriter;
  }

  public static int calculate() throws IOException {

    int sizeOfArray = inputReader.readNextInt();
    int count = -1;
    while (sizeOfArray-- > 0) {

//    Read new line
      inputReader.readNextChar();
      count = -1;
      char ch = inputReader.readNextChar();

      while (!inputReader.isWhiteSpace((int) ch)) {

        switch (ch) {
          case 'A':
            ++count;
            break;

          case 'E':
            ++count;
            break;

          case 'I':
            ++count;
            break;

          case 'O':
            ++count;
            break;

          case 'U':
            ++count;
            break;

          case 'a':
            ++count;
            break;

          case 'e':
            ++count;
            break;

          case 'i':
            ++count;
            break;

          case 'o':
            ++count;
            break;

          case 'u':
            ++count;
            break;
          default:
            break;
        }

        ch = inputReader.readNextChar();
      }

      if (outputWriter != null && count > -1) {

        outputWriter.println(count + 1);
      }
    }

    return count + 1;
  }
}
