package com.hackerearth.practices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinearSearch {

    private final InputReader inputReader;
    private final OutputWriter outputWriter;

    public LinearSearch(InputReader inputReader, OutputWriter outputWriter) {

        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }

    public int calculate() throws IOException {

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

            if (outputWriter != null) {

                outputWriter.println(lastIndex);
            }
        }

        return lastIndex;
    }
}
