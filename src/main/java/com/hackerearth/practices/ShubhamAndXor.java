package com.hackerearth.practices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * You are given an array of n integer numbers a1, a2, a3.. ,an. Calculate the number of pair of indices(i, j ) such
 * that 1<=i<j<=n and ai xor aj = 0.
 * <p>Input format - First line: n denoting the number of array elements - Second line: n space
 * separated integers a1, a2, .. ,an.
 * <p>.
 * <p>Output format Output the required number of pairs.
 * <p>Constraints
 * 1<=n<=10 power 6 1<=ai<=10 power 9
 */
public class ShubhamAndXor {

  private final OutputWriter outputWriter;
  private final InputReader inputReader;

  public ShubhamAndXor(InputReader inputReader, OutputWriter outputWriter) {

    this.outputWriter = outputWriter;
    this.inputReader = inputReader;
  }

  public int calculate() throws IOException {

    // Write your code here
    int arraySize = inputReader.readNextInt();
    List<Integer> array = new ArrayList<>(1);
    int counter = 0;

    while (arraySize-- > 0) {

      array.add(inputReader.readNextInt());
    }

    for (int outerIndex = 0; outerIndex < array.size(); outerIndex++) {

      for (int innerIndex = outerIndex + 1; innerIndex < array.size(); innerIndex++) {

        if ((array.get(innerIndex) ^ array.get(outerIndex)) == 0) {

          counter++;
        }
      }
    }

    if (outputWriter != null) {

      outputWriter.println(counter);
    }

    return counter;
  }
}
