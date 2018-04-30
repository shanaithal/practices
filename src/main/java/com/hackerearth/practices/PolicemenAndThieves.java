package com.hackerearth.practices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PolicemenAndThieves {

  private final InputReader inputReader;
  private final OutputWriter outputWriter;

  public PolicemenAndThieves(InputReader inputReader, OutputWriter outputWriter) {

    this.inputReader = inputReader;
    this.outputWriter = outputWriter;
  }

  public int calculate() throws IOException {

    int numberOfTestCases = inputReader.readNextInt();

    int count = 0;
    while (numberOfTestCases-- > 0) {

      count = 0;
      int sizeOfPersonMatrix = inputReader.readNextInt();
      List<List<String>> persons = new ArrayList<>();
      int numberOfBlockPoliceCanReach = inputReader.readNextInt();
      inputReader.readNextChar();
      for (int outerIndex = 0; outerIndex < sizeOfPersonMatrix; outerIndex++) {

        persons.add(new ArrayList<>(sizeOfPersonMatrix));
        for (int innerIndex = 0; innerIndex < sizeOfPersonMatrix; innerIndex++) {

          char person = inputReader.readNextChar();
          persons.get(outerIndex).add(String.valueOf(person));

          char whitespace = inputReader.readNextChar();
          if (!inputReader.isWhiteSpace(whitespace)) {

            System.err.println("Missed the character: " + whitespace);
          }
        }

        count +=
                calculateCount(
                        sizeOfPersonMatrix, numberOfBlockPoliceCanReach, persons.get(outerIndex), 0);
        inputReader.readNextChar();
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
