package com.hackerearth.practices;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch {

    public static void main(String[] args) throws Exception {

        InputReader inputReader = new InputReader();

        int sizeOfArray = inputReader.readNextInt();
        int searchInt = inputReader.readNextInt();
        int lastIndex = -1;

        List<Integer> array = new ArrayList<>(1);

        while (sizeOfArray-- > 0) {

            array.add(inputReader.readNextInt());
            if (array.contains(searchInt)) {

                lastIndex = array.lastIndexOf(searchInt) + 1;
            }
        }

        if (lastIndex > -1) {

            System.out.println(lastIndex);
        }
    }
}
