package com.hackerearth.practices;

import java.util.ArrayList;
import java.util.List;

public class ShubhamAndXor {

    public static void main(String args[]) throws Exception {

        // Write your code here
        InputReader inputReader = new InputReader();
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

        System.out.println(counter);
    }
}