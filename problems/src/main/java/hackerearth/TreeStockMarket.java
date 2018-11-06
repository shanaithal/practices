package hackerearth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Mr X is very curious to know about the frequency of stocks. But unfortunately for him, the stocks
 * are represented as nodes of a tree with prices of the stocks as their value. Mr X hates trees as
 * much as he loves to learn about stocks. So he asks for your help:
 *
 * <p>Given a tree with N nodes (each node represents a stock) numbered from 1 to N (rooted at 1).
 * Each stock has a price/value which is denoted by Pi. He is very curious so he asks a lot of
 * questions of the form: U L R . For each of his question he wants to know how many different stock
 * prices/values are present in the subtree of U for which frequency is between L and R(Both
 * inclusive).
 *
 * <p>Constraints :
 *
 * <p>1<=N,Q,U<=105
 *
 * <p>1<=L<=R<=105
 *
 * <p>1<=Pi<=105
 *
 * <p>INPUT:
 *
 * <p>The first line contains 2 space seperated integers N and Q, the number of nodes in the tree
 * and the number of queries
 *
 * <p>Following N-1 lines contains 2 integers a and b denoting an edge between a and b
 *
 * <p>Next line contains N space seperated integers denoting the value of each node
 *
 * <p>Following Q lines contains 3 space seperated integers U,L,R
 *
 * <p>OUTPUT:
 *
 * <p>Output Q lines containing the answer of each query.
 *
 * <p>Hint :
 *
 * <p>Sack DSU on tree
 *
 * 27d76f6c31
 */
public class TreeStockMarket {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in, "UTF-8");
    int numberOfNodes = scanner.nextInt();
    int numberOfQueries = scanner.nextInt();
    List<List<Integer>> edge = new ArrayList<>(numberOfNodes);
    List<Integer> valueOfNodes = new ArrayList<>(numberOfNodes);
    List<List<Integer>> questionForNodes = new ArrayList<>(numberOfQueries);

    for (int index = 0; index < numberOfNodes - 1; index++) {

      List<Integer> elements = new ArrayList<>(2);
      elements.add(scanner.nextInt());
      elements.add(scanner.nextInt());
      edge.add(index, elements);
    }

    for (int index = 0; index < numberOfNodes; index++) {

      valueOfNodes.add(scanner.nextInt());
    }

    for (int index = 0; index < numberOfQueries; index++) {

      List<Integer> questions = new ArrayList<>(3);
      questions.add(scanner.nextInt());
      questions.add(scanner.nextInt());
      questions.add(scanner.nextInt());
      questionForNodes.add(index, questions);
    }
  }
}
