package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.io.OutputWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * You have been given an array of size N consisting of integers. In addition you have been given an
 * element M you need to find and print the index of the last occurrence of this element M in the
 * array if it exists in it, otherwise print -1. Consider this array to be 1 indexed.
 *
 * <p>Input Format:
 *
 * <p>The first line consists of 2 integers N and M denoting the size of the array and the element
 * to be searched for in the array respectively . The next line contains N space separated integers
 * denoting the elements of of the array.
 *
 * <p>Output Format
 *
 * <p>Print a single integer denoting the index of the last occurrence of integer M in the array if
 * it exists, otherwise print -1.
 *
 * <p>Constraints 1<=N<=10 power 5 1<=A[i]<=10 power 9 1<=M<=10 power 9
 */
public class LastOccurrence {

  private InputReader inputReader;
  private OutputWriter outputWriter;

  public LastOccurrence(InputReader inputReader, OutputWriter outputWriter) {

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

    if (lastIndex > -1 && outputWriter != null) {

      outputWriter.println(lastIndex);
    }

    return lastIndex;
  }
}
