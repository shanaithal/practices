package hackerearth;

import java.util.Scanner;

class TestClass {
  public static void main(String args[]) {

    calculate();
  }

  public static void calculate() {

    Scanner inputReader = new Scanner(System.in);

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
      stringB.replace(indexToUpdate, indexToUpdate, "1");

      if (Integer.parseInt(stringA.toString(), 2) < Integer.parseInt(stringB.toString(), 2)) {

        System.out.println("NO");
      } else {

        System.out.println("YES");
      }
    }
  }
}
