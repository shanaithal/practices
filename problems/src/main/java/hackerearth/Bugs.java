package hackerearth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * You are developer at XYZ company. You like to call the bugs in your code as enemies. You maintain
 * an array A of the list of enemies in decreasing order of their difficulty i.e., the most
 * difficult bug will be the first element of the array. Initally, there is no bugs in the code. You
 * are given N tasks. Each task contains one of the following two types of operations:
 *
 * <p>1. 1 P: Add a bug with difficulty P into the array A.
 *
 * <p>2. 2: Sort the array in decreasing order and print the difficulty of (n / 3)th bug in the
 * sorted array, where n is the size of the array A. If the number of bugs is less than 3, print Not
 * enough enemies.
 *
 * <p>Input Format
 *
 * <p>First line contains an integer N, denoting the number of tasks.
 *
 * <p>The next N lines contain one of the two types of operations mentioned above.
 *
 * <p>Output Format
 *
 * <p>For every operation of type 2, print the difficulty of (n / 3)th bug in the sorted array,
 * where n is the size of the array A. If the number of bugs is less than 3, print Not enough
 * enemies.
 *
 * <p>Constraints:
 *
 * <p>1 <= N <= 5*10 power 5
 */
public class Bugs {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in, "UTF-8");
    int numberOfTasks = scanner.nextInt();
    List<Integer> bugs = new ArrayList<>(numberOfTasks);
    while (numberOfTasks-- > 0) {

      switch (scanner.nextInt()) {
        case 1:
          bugs.add(scanner.nextInt());
          break;
        case 2:
          Collections.sort(bugs, Collections.reverseOrder());
          int bugRank = bugs.size() / 3;
          if (bugRank < 1) {

            System.out.println("Not enough enemies");
          } else {

            System.out.println(bugs.get(bugRank - 1));
          }
          break;
      }
    }
  }
}
