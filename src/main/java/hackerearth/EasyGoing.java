package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.io.OutputWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Coders here is a simple task for you, you have given an array of size N and an integer M. Your
 * task is to calculate the difference between maximum sum and minimum sum of N-M elements of the
 * given array.
 *
 * <p>Constraints: 1<=t<=10 1<=n<=1000 1<=a[i]<=1000
 *
 * <p>Input: First line contains an integer T denoting the number of test cases. First line of every
 * testcase contains two integer N and M. Next line contains N space separated integers denoting the
 * elements of array.
 *
 * <p>Output: For every test case print your answer in new line
 */
public class EasyGoing {

  private InputReader inputReader;
  private OutputWriter outputWriter;

  public EasyGoing(InputReader inputReader, OutputWriter outputWriter) {

    this.inputReader = inputReader;
    this.outputWriter = outputWriter;
  }

  private void bubbleSort(int arraySize, List<Integer> inputIntegerArray) {

    for (int outerIndex = 0; outerIndex < arraySize - 1; outerIndex++) {

      for (int innerIndex = 0; innerIndex < arraySize - outerIndex - 1; innerIndex++) {

        int nextInnerIndex = innerIndex + 1;
        if (inputIntegerArray.get(innerIndex) > inputIntegerArray.get(nextInnerIndex)) {

          Collections.swap(inputIntegerArray, innerIndex, nextInnerIndex);
        }
      }
    }
  }

  public int calculate() throws IOException {

    // Write your code here
    int testCaseNumber = inputReader.nextInt();

    List<Integer> inputArray;
    int result = 0;
    for (int testCaseIndex = 0; testCaseIndex < testCaseNumber; testCaseIndex++) {

      int variableN = inputReader.nextInt();
      int variableM = inputReader.nextInt();

      inputArray = new ArrayList<>(variableN);
      while (variableN-- > 0) {

        inputArray.add(inputReader.nextInt());
      }

      int length = variableN = inputArray.size();
      getBubbleSort().bubbleSort(length, inputArray, 0);
      int numberOfArrayElementsToBeConsidered = Math.abs(variableM - variableN);

      int maxSum = 0;
      int minSum = 0;
      for (int index = 0; index < numberOfArrayElementsToBeConsidered; index++) {

        maxSum += inputArray.get(length - 1 - index);
        minSum += inputArray.get(index);
      }

      result = maxSum - minSum;

      if (outputWriter != null) {

        outputWriter.println(result);
      }
    }

    return result;
  }

  private BubbleSort getBubbleSort() {
    return new BubbleSort(null, null);
  }
}
