package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.io.OutputWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * You are given a grid of size N * N
 *
 * <p>that has the following specifications:
 *
 * <p>Each cell in the grid contains either a policeman or a thief. A policeman can only catch a
 * thief if both of them are in the same row. Each policeman can only catch one thief. A policeman
 * cannot catch a thief who is more than K units away from the policeman.
 *
 * <p>Write a program to find the maximum number of thieves that can be caught in the grid.
 *
 * <p>Input format
 *
 * <p>First line: T (number of test cases) For each test case First line: Two space-separated
 * integers N and K Next N lines: N space-separated characters (denoting each cell in the grid)
 *
 * <p>Output format
 *
 * <p>For each test case, print the maximum number of thieves that can be caught in the grid.
 *
 * <p>Constraints 1<=T<=10 1<=N<=1000 1<=K<=N*N
 */
public class PolicemenAndThieves {

  private final InputReader inputReader;
  private final OutputWriter outputWriter;

  public PolicemenAndThieves(InputReader inputReader, OutputWriter outputWriter) {

    this.inputReader = inputReader;
    this.outputWriter = outputWriter;
  }

  public int calculate() throws IOException {

    int numberOfTestCases = inputReader.nextInt();

    int count = 0;
    while (numberOfTestCases-- > 0) {

      count = 0;
      int sizeOfPersonMatrix = inputReader.nextInt();
      List<List<String>> persons = new ArrayList<>();
      int numberOfBlockPoliceCanReach = inputReader.nextInt();
      inputReader.nextChar();
      for (int outerIndex = 0; outerIndex < sizeOfPersonMatrix; outerIndex++) {

        persons.add(new ArrayList<>(sizeOfPersonMatrix));
        for (int innerIndex = 0; innerIndex < sizeOfPersonMatrix; innerIndex++) {

          char person = inputReader.nextChar();
          persons.get(outerIndex).add(String.valueOf(person));

          char whitespace = inputReader.nextChar();
          if (!inputReader.isWhiteSpace(whitespace) && outputWriter != null) {

            outputWriter.println("Missed the character: " + whitespace);
          }
        }

        count +=
            calculateCount(
                sizeOfPersonMatrix, numberOfBlockPoliceCanReach, persons.get(outerIndex), 0);
        inputReader.nextChar();
      }

      if (outputWriter != null) {

        outputWriter.println(count);
      }
    }

    return count;
  }

  private int calculateCount(
      int sizeOfPersonMatrix, int numberOfBlockPoliceCanReach, List<String> persons, int count) {

    for (String person : persons) {

      if ("P".equals(person)) {

        int positionOfPolice = persons.indexOf("P");
        int lastReachableIndex = positionOfPolice + numberOfBlockPoliceCanReach;
        if (lastReachableIndex >= sizeOfPersonMatrix) {

          lastReachableIndex = sizeOfPersonMatrix - 1;
        }
        int lastIndex = positionOfPolice + 1;
        while (lastIndex <= lastReachableIndex) {
          if ("T".equals(persons.get(lastIndex))) {

            persons.set(positionOfPolice, "C");
            persons.set(lastIndex, "C");
            count++;
            break;
          }
          lastIndex++;
        }
        persons.set(positionOfPolice, "C");
      } else if ("T".equals(person)) {

        int positionOfThief = persons.indexOf("T");
        int lastReachableIndex = positionOfThief + numberOfBlockPoliceCanReach;
        if (lastReachableIndex >= sizeOfPersonMatrix) {

          lastReachableIndex = sizeOfPersonMatrix - 1;
        }
        int lastIndex = positionOfThief + 1;
        while (lastIndex <= lastReachableIndex) {
          if ("P".equals(persons.get(lastIndex))) {

            persons.set(positionOfThief, "C");
            persons.set(lastIndex, "C");
            count++;
            break;
          }
          lastIndex++;
        }

        persons.set(positionOfThief, "C");
      }
    }

    return count;
  }
}
