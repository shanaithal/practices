package com.hackerearth.practices;

import com.hackerearth.practices.util.FileType;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

class OutputWriter {

    private OutputStream outputStream;

    OutputWriter() throws UnsupportedEncodingException {

        outputStream = new PrintStream(System.out, true, FileType.UTF_8.value());
    }

    void println(int integer) {

        if (outputStream instanceof PrintStream) {

            ((PrintStream) outputStream).print(integer);
            ((PrintStream) outputStream).print("\n");
        }
    }

    public void close() throws IOException {

        outputStream.close();
    }

    public void println(String string) {

        if (outputStream instanceof PrintStream) {

            ((PrintStream) outputStream).print(string);
            ((PrintStream) outputStream).print("\n");
        }
    }
}
