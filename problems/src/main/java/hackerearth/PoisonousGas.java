package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.io.OutputWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * You are in a battle field and your enemy has an army of N soldiers. Each soldier has a strength
 * denoted by an array A. Your enemy will select some soldiers such that total strength of selected
 * soldiers is maximum. You have a poisonous gas and you can use it on the selected soldiers as many
 * times as you want. If the total strength is even, the poisonous gas will decrease the total
 * strength of the selected soldiers to half of the total strength, otherwise it will not affect
 * them. Your task is to tell if its possible to reduce the total strength to 1 or not.
 *
 * <p>Input Format:
 *
 * <p>First line contains an integer T, denoting the number of test cases.
 *
 * <p>First line of each test case contains an integer N, denoting the number of soldiers.
 *
 * <p>Second line of each test case contains N space-separated integers, denoting the strength of
 * the soldiers.
 *
 * <p>Output Format:
 *
 * <p>For each test case, print Yes if its possible to reduce the total strength to 1, otherwise
 * print No.
 *
 * <p>Explanation
 *
 * <p>Test case 1: n = 5 and maximum total strength is 76 + 56 + 76 = 208. You can not reduce 208 to
 * 1 by using the poisonous gas.
 *
 * <p>Test case 2: n = 2 and maximum total strength is 8. First time when you will use the poisonous
 * gas, total strength will reduce to 4. Second time when you will use the poisonous gas, total
 * strength will reduce to 2. Third time when you will use the poisonous gas, total strength will
 * reduce to 1. Therefore, the answer is Yes
 */
public class PoisonousGas {

  private final InputReader inputReader;

  private final OutputWriter outputWriter;

  public PoisonousGas(InputReader inputReader, OutputWriter outputWriter) {

    this.inputReader = inputReader;
    this.outputWriter = outputWriter;
  }

  public String calculate() throws IOException {

    int numberOfTestCases = inputReader.nextInt();
    String response = "";
    while (numberOfTestCases-- > 0) {

      int sum = 0;
      int arraySize = inputReader.nextInt();
      List<Integer> array = new ArrayList<>(1);
      while (arraySize-- > 0) {

        int arrayElement = inputReader.nextInt();
        sum += arrayElement;
        array.add(arrayElement);
      }
      while (sum > 0) {

        if (sum % 2 > 0) {
          break;
        }
        sum /= 2;
      }
      if (sum == 1) {

        response = "Yes";
        if (outputWriter != null) {
          outputWriter.println(response);
        }
      } else {
        response = "No";
        if (outputWriter != null) {
          outputWriter.println(response);
        }
      }
    }

    return response;
  }
}
