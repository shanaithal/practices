package com.hackerearth.practices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a permutation of 1 to n, you need to perform some operations to make it into increasing order. Each operation
 * is to reverse an interval a1, a2, a3,....ax(1<=x<=n)
 *
 * <p>(a prefix). Your goal is to minimize the number of operations.
 *
 * <p>Input
 *
 * <p>The first line contains an integer (1<=n<=8).
 *
 * <p>The second line contains n space separated integers, representing the sequence a/
 *
 * <p>.
 *
 * <p>Output
 *
 * <p>An integer representing the answer, that is, the minimum number of operations needed to make
 * the permutation into increasing order.
 */
public class AprilCircuits18Permutation {

    public static void main(String[] args) throws Exception {

        InputReader inputReader = new InputReader();

        int sizeOfArray = inputReader.readNextInt();
        List<Integer> array = new ArrayList<>(1);

        while (sizeOfArray-- > 0) {

            array.add(inputReader.readNextInt());
        }

        sizeOfArray = array.size();
        findMinNumberOfOperations(array, sizeOfArray);
    }

    private static void findMinNumberOfOperations(List<Integer> array, int sizeOfArray) {

        int count = 0;
        while (sizeOfArray > 1) {

            int startIndex = 0;
            int endIndex = sizeOfArray - 1;
            while (endIndex < array.size()) {
                List<Integer> subList = array.subList(startIndex, endIndex + 1);
                Collections.reverse(subList);
                count++;
                if (isSorted(array)) {

                    break;
                }
                startIndex++;
                endIndex++;
            }
            if (isSorted(array)) {

                break;
            }
            sizeOfArray--;
        }

        System.out.println(count);
    }

    public static boolean isSorted(List<Integer> array) {

        for (int i = 0; i < array.size() - 1; i++) {

            if (array.get(i) > array.get(i + 1)) {

                return false;
            }
        }

        return true;
    }
}
