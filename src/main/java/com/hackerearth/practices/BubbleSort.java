package com.hackerearth.practices;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Sorting Algorithms are concepts that every competitive programmer must know. Sorting algorithms can be used for
 * collections of numbers, strings, characters, or a structure of any of these types.
 *
 * <p>Bubble sort is based on the idea of repeatedly comparing pairs of adjacent elements and then
 * swapping their positions if they exist in the wrong order.
 *
 * <p>Assume that A[] is an unsorted array of
 *
 * <p>elements. This array needs to be sorted in ascending order. The pseudo code is as follows:
 *
 * <p>void bubble_sort( int A[ ], int n ) { int temp; for(int k = 0; k< n-1; k++) { // (n-k-1) is
 * for ignoring comparisons of elements which have already been compared in earlier iterations
 *
 * <p>for(int i = 0; i < n-k-1; i++) { if(A[ i ] > A[ i+1] ) { // here swapping of positions is
 * being done. temp = A[ i ]; A[ i ] = A[ i+1 ]; A[ i + 1] = temp; } } } }
 *
 * <p>Lets try to understand the pseudo code with an example: A [ ] = { 7, 4, 5, 2}
 *
 * <p>enter image description here
 *
 * <p>In step 1, 7 is compared with 4. Since 7 > 4, 7 is moved ahead of 4. Since all the other
 * elements are of a lesser value than 7,
 *
 * <p>7 is moved to the end of the array.
 *
 * <p>Now the array is
 *
 * <p>A[] = { 4, 5, 2, 7}.
 *
 * <p>In step 2, 4 is compared with 5. Since 5 > 4 and both 4 and 5 are in ascending order, these
 * elements are not swapped. However, when 5 is compared with 5 > 2, and these elements are in descending order.
 * Therefore, 5 and 2
 *
 * <p>are swapped.
 *
 * <p>Now the array is
 *
 * <p>A[] = { 4, 2, 5, 7}.
 *
 * <p>In step 3, the element 4 is compared with 2. Since 4 > 2 and the elements are in descending
 * order, 4 and 2
 *
 * <p>are swapped.
 *
 * <p>The sorted array is
 *
 * <p>A[] = { 2, 4, 5, 7}.
 *
 * <p>Complexity: The complexity of bubble sort is O(n square) in both worst and average cases,
 * because the entire array needs to be iterated for every element.
 */
public class BubbleSort {

    public static void main(String[] args) throws Exception {

        InputReader inputReader = new InputReader();

        int sizeOfArray = inputReader.readNextInt();
        List<Integer> array = new ArrayList<>(1);

        while (sizeOfArray-- > 0) {

            array.add(inputReader.readNextInt());
        }

        bubbleSort(array, array.size());
    }

    static void bubbleSort(List<Integer> array, int sizeOfArray) {

        PrintStream printStream = new PrintStream(System.out);
        int count = 0;

        for (int k = 0; k < sizeOfArray - 1; k++) {

            for (int i = 0; i < sizeOfArray - k - 1; i++) {

                if (array.get(i) > array.get(i + 1)) {

                    ++count;
                    Collections.swap(array, i, i + 1);
                }
            }
        }

        printStream.println(count);
    }
}
