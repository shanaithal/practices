package com.hackerearth.practices;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Selection sort algorithm is based on the idea of finding the minimum or maximum element in an
 * unsorted array and then putting it in its correct position in a sorted array.
 *
 * <p>Assume that the array A = [7, 5, 4, 2]
 *
 * <p>needs to be sorted in ascending order.
 *
 * <p>The minimum element in the array i.e. 2 is searched for and then swapped with the element that
 * is currently located at the first position, i.e. 7
 *
 * <p>. Now the minimum element in the remaining unsorted array is searched for and put in the
 * second position, and so on.
 *
 * <p>Let’s take a look at the implementation.
 *
 * <p>void selection_sort (int A[ ], int n) { // temporary variable to store the position of minimum
 * element
 *
 * <p>int minimum; // reduces the effective size of the array by one in each iteration.
 *
 * <p>for(int i = 0; i < n-1 ; i++) {
 *
 * <p>// assuming the first element to be the minimum of the unsorted array . minimum = i ;
 *
 * <p>// gives the effective size of the unsorted array .
 *
 * <p>for(int j = i+1; j < n ; j++ ) { if(A[ j ] < A[ minimum ]) { //finds the minimum element
 * minimum = j ; } } // putting minimum element on its proper position. swap ( A[ minimum ], A[ i ])
 * ; } }
 *
 * <p>At i'th iteration, elements from position 0 to i - 1
 *
 * <p>will be sorted.
 *
 * <p>enter image description here
 *
 * <p>Time Complexity:
 *
 * <p>To find the minimum element from the array of N elements, N - 1 comparisons are required.
 * After putting the minimum element in its proper position, the size of an unsorted array reduces
 * to N - 1 and then N - 2
 *
 * <p>comparisons are required to find the minimum in the unsorted array.
 *
 * <p>Therefore (N - 1) + (N - 2) + ...... + 1 = (N * (N - 1)) / 2 comparisons and N swaps result in
 * the overall complexity of O(N square).
 */
public class SelectionSort {

    private final InputReader inputReader;

    public SelectionSort(InputReader inputReader) {

        this.inputReader = inputReader;
    }

    private static OutputWriter getOutputWriter() throws UnsupportedEncodingException {

        return new OutputWriter();
    }

    public List<Integer> calculate() throws IOException {

    int sizeOfArray = inputReader.readNextInt();
    int numberOfSteps = inputReader.readNextInt();

    List<Integer> array = new ArrayList<>(1);

    while (sizeOfArray-- > 0) {

      array.add(inputReader.readNextInt());
    }

        return selectionSort(array, array.size(), numberOfSteps);
  }

    List<Integer> selectionSort(List<Integer> array, int sizeOfArray, int numberOfSteps)
            throws IOException {

    int minimum;

    for (int i = 0; i < sizeOfArray - 1; i++) {

      if (numberOfSteps == i) {

        break;
      }
      minimum = i;
      for (int j = i + 1; j < sizeOfArray; j++) {

        if (array.get(minimum) > array.get(j)) {

          minimum = j;
        }
      }

      Collections.swap(array, i, minimum);
    }

    for (Integer integer : array) {

      getOutputWriter().println(integer);
      if (array.indexOf(integer) != array.size()) {

        getOutputWriter().println(" ");
      }
    }

        return array;
  }
}
