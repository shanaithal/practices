package com.hackerearth.practices;

class InputReader {
    private byte[] buf = new byte[10240];    //Buffer of Bytes
    private int index;
    private java.io.InputStream in;
    private int total;

    public InputReader() {
        in = System.in;
    }

    public int readNextInt() throws java.io.IOException {

        int integer = 0;
        int n = scan();

        while (isWhiteSpace(n))    //Removing starting whitespaces

            n = scan();

        int neg = 1;
        if (n == '-') {               //If Negative Sign encounters

            neg = -1;
            n = scan();
        }

        while (!isWhiteSpace(n)) {

            if (n >= '0' && n <= '9') {
                integer *= 10;
                integer += n - '0';
                n = scan();
            } else

                throw new java.util.InputMismatchException();
        }

        return neg * integer;
    }

    public int scan() throws java.io.IOException {    //Scan method used to scan buf

        if (total < 0)

            throw new java.util.InputMismatchException();

        if (index >= total) {

            index = 0;
            total = in.read(buf);
            if (total <= 0)
                return -1;
        }

        return buf[index++];
    }

    public boolean isWhiteSpace(int n) {

        return n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1;

    }

    public char readNextChar() {

        int val = ' ';
        try {

            val = scan();
        } catch (Exception e) {
        }

        return (char) val;
    }
}