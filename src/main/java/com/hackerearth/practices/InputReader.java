package com.hackerearth.practices;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

class InputReader {

  private final byte[] buf = new byte[10240]; // Buffer of Bytes
  private int index;
  private InputStream inputStream;
  private int total;

  public InputReader() {
      this(System.in);
  }

  InputReader(InputStream inputStream) {

    this.inputStream = inputStream;
  }

  public int readNextInt() throws IOException {

    int integer = 0;
    int n = scan();

    while (isWhiteSpace(n)) // Removing starting whitespaces
        n = scan();

    int neg = 1;
    if (n == '-') { // If Negative Sign encounters

      neg = -1;
      n = scan();
    }

    while (!isWhiteSpace(n)) {

      if (n >= '0' && n <= '9') {
        integer *= 10;
        integer += n - '0';
        n = scan();
      } else throw new InputMismatchException();
    }

    return neg * integer;
  }

  public int scan() throws IOException { // Scan method used to scan buf

    if (total < 0) throw new InputMismatchException();

    if (index >= total) {

      index = 0;
      total = inputStream.read(buf);
      if (total <= 0) return -1;
    }

    return buf[index++];
  }

  public boolean isWhiteSpace(int n) {

      return n == ' ' || isNewLine(n) || n == '\r' || n == '\t' || n == -1;
  }

    boolean isNewLine(int n) {

        return n == '\n';
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
