package hackerearth.io;

import hackerearth.util.FileType;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class OutputWriter {

  private OutputStream outputStream;

  public OutputWriter() throws UnsupportedEncodingException {

    outputStream = new PrintStream(System.out, true, FileType.UTF_8.value());
  }

  public void println(int integer) {

    if (outputStream instanceof PrintStream) {

      ((PrintStream) outputStream).print(integer);
      ((PrintStream) outputStream).print("\n");
    }
  }

  public void println(String string) {

    if (outputStream instanceof PrintStream) {

      ((PrintStream) outputStream).print(string);
      ((PrintStream) outputStream).print("\n");
    }
  }

  public void close() throws IOException {

    if (outputStream != null) {

      outputStream.close();
    }
  }

  @Override
  protected void finalize() throws Throwable {

    close();
    super.finalize();
  }
}
