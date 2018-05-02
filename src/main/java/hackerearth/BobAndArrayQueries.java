package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.io.OutputWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Bob has an array A[] of N integers. Initially, all the elements of the array are zero. Bob asks
 * you to perform Q operations on this array.
 *
 * <p>There are three types of operations that can be performed:
 *
 * <p>1 X: Update the value of A[X] to 2 * A[X] + 1. 2 X: Update the value A[X] to
 *
 * <p>A[x]/2 , where
 *
 * <p>is Greatest Integer Function. 3 X Y: Take all the A[i] such that X <= i <= Y and convert them
 * into their corresponding binary strings. Now concatenate all the binary strings and find the
 * total no. of '1' in the resulting string.
 *
 * <p>Note: It is guaranteed that there is at least 1 type-3 query in the every test case. All the
 * array elements will fit into 64 bit integers.
 *
 * <p>Input Format: First line consists of two space-separated integers N and Q. Next, Q lines
 * consist of Q operations of either of the 3 types as described above.
 *
 * <p>Output Format: For each type-3 query print the answer that is the no. of '1' in the resulting
 * string.
 *
 * <p>Constraints:
 *
 * <p>1 <= N,Q < 500000
 *
 * <p>1 <= X <= Y <= N
 *
 * <p>Explanation
 *
 * <p>Initially, A=[0,0,0,0,0]
 *
 * <p>After 1st query, A=[1,0,0,0,0]
 *
 * <p>After 2nd query, A=[1,1,0,0,0]
 *
 * <p>After 3rd query, A=[1,1,1,0,0]
 *
 * <p>For 4th query, no. of '1' in binary representation of A[1]=A[2]=A[3]=1. So, answer=3.
 *
 * <p>For 5th query, answer is 2.
 */
public class BobAndArrayQueries {

  private final InputReader inputReader;

  private final OutputWriter outputWriter;

  public BobAndArrayQueries(InputReader inputReader, OutputWriter outputWriter) {

    this.inputReader = inputReader;
    this.outputWriter = outputWriter;
  }

  public int calculate() throws IOException {

    int result = 0;
    int arraySize = inputReader.nextInt();
    int[] array = new int[arraySize];
    Map<Integer, String> binMap = new HashMap<>(arraySize);

    int numberOfOperations = inputReader.nextInt();
    while (numberOfOperations-- > 0) {

      int operationType = inputReader.nextInt();
      switch (operationType) {
        case 1:
          int index = inputReader.nextInt() - 1;
          result = 2 * array[index] + 1;
          array[index] = result;
          binMap.put(result, Integer.toBinaryString(result));
          break;
        case 2:
          index = inputReader.nextInt() - 1;
          result = Math.floorDiv(array[index], 2);
          array[index] = result;
          array[index] = result;
          binMap.put(result, Integer.toBinaryString(result));
          break;
        case 3:
          int startIndex = inputReader.nextInt() - 1;
          startIndex = startIndex < 0 ? 0 : startIndex;
          int endIndex = inputReader.nextInt() - 1;
          endIndex = endIndex >= arraySize ? arraySize - 1 : endIndex;
          StringBuilder binStringBuilder = new StringBuilder();
          for (int loopIndex = startIndex; loopIndex <= endIndex; loopIndex++) {

            binStringBuilder.append(binMap.containsKey(array[loopIndex]) ? binMap.get(array[loopIndex]) : "");
          }
          String binString = binStringBuilder.toString().replaceAll("0", "");
          result = binString.length();
          break;
      }
      if (outputWriter != null && operationType == 3) {

        outputWriter.println(result);
      }
    }

    return result;
  }
}
