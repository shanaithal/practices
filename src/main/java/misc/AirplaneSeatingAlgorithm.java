package misc;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.format;

public class AirplaneSeatingAlgorithm {

  private Scanner scanner;

  public AirplaneSeatingAlgorithm(InputStream inputStream) {

    this.scanner = new Scanner(inputStream, "UTF-8");
  }

  List<int[][]> calculate() {

    int numberOfSeatBlocks = scanner.nextInt();
    int maxRowCount = 0;
    List<int[][]> seatBlocks = new ArrayList<>();
    while (numberOfSeatBlocks-- > 0) {

      int columnCount = scanner.nextInt();
      int rowCount = scanner.nextInt();
      int[][] seatBlock = new int[rowCount][columnCount];
      seatBlocks.add(seatBlock);
      if (maxRowCount < rowCount) {

        maxRowCount = rowCount;
      }
    }

    int numberOfPassengers = scanner.nextInt();

    int assignment = 1;

    assignment = assignIsleSeats(assignment, seatBlocks, maxRowCount, numberOfPassengers);
    assignment = assignWindowSeats(assignment, seatBlocks, maxRowCount, numberOfPassengers);
    assignment = assignRemainingSeats(assignment, seatBlocks, maxRowCount, numberOfPassengers);

    for (int index = 0; index < seatBlocks.size(); index++) {

      System.out.println("Block " + (index + 1) + " : ");
      new PrettyPrinter(System.out).print(seatBlocks.get(index));
      System.out.println();
    }

    return seatBlocks;
  }

  private int assignRemainingSeats(
      int assignment, List<int[][]> seatBlocks, int maxRowCount, int numberOfPassengers) {

    int rowIndex = 0;
    while (assignment < numberOfPassengers) {

      if (rowIndex > maxRowCount) {

        break;
      }
      for (int index = 0; index < seatBlocks.size(); index++) {

        if (assignment > numberOfPassengers) {

          break;
        }
        int[][] seatBlock = seatBlocks.get(index);
        if (rowIndex < seatBlock.length) {

          for (int columnIndex = 0; columnIndex < seatBlock[rowIndex].length; columnIndex++) {

            if (seatBlock[rowIndex][columnIndex] == 0) {

              if (assignment > numberOfPassengers) {

                break;
              }
              seatBlock[rowIndex][columnIndex] = assignment++;
            }
          }
        }
      }

      rowIndex++;
    }

    return assignment;
  }

  private int assignWindowSeats(
      int assignment, List<int[][]> seatBlocks, int maxRowCount, int numberOfPassengers) {

    int rowIndex = 0;
    while (assignment < numberOfPassengers) {

      if (rowIndex > maxRowCount) {

        break;
      }
      int[][] seatBlock = seatBlocks.get(0);
      if (rowIndex < seatBlock.length) {
        if (seatBlock[rowIndex][0] == 0) {

          if (assignment > numberOfPassengers) {

            break;
          }
          seatBlock[rowIndex][0] = assignment++;
        }
      }
      seatBlock = seatBlocks.get(seatBlocks.size() - 1);
      if (rowIndex < seatBlock.length) {
        if (seatBlock[rowIndex][seatBlock[rowIndex].length - 1] == 0) {

          if (assignment > numberOfPassengers) {

            break;
          }
          seatBlock[rowIndex][seatBlock[rowIndex].length - 1] = assignment++;
        }
      }
      rowIndex++;
    }

    return assignment;
  }

  private int assignIsleSeats(
      int assignment,
      List<int[][]> seatBlocks,
      final double maxRowCount,
      final double numberOfPassengers) {

    int rowIndex = 0;
    while (assignment < numberOfPassengers) {

      if (rowIndex > maxRowCount) {

        break;
      }
      for (int index = 0; index < seatBlocks.size(); index++) {

        int[][] seatBlock = seatBlocks.get(index);

        if (index == 0) {

          if (rowIndex < seatBlock.length) {
            if (seatBlock[rowIndex][seatBlock[rowIndex].length - 1] == 0) {

              if (assignment > numberOfPassengers) {

                break;
              }
              seatBlock[rowIndex][seatBlock[rowIndex].length - 1] = assignment++;
            }
          }
        } else if (index == seatBlocks.size() - 1) {

          if (rowIndex < seatBlock.length) {
            if (seatBlock[rowIndex][0] == 0) {

              if (assignment > numberOfPassengers) {

                break;
              }
              seatBlock[rowIndex][0] = assignment++;
            }
          }
        } else {

          if (rowIndex < seatBlock.length) {
            if (seatBlock[rowIndex][0] == 0
                && seatBlock[rowIndex][seatBlock[rowIndex].length - 1] == 0) {

              if (assignment > numberOfPassengers) {

                break;
              }
              seatBlock[rowIndex][0] = assignment++;
              seatBlock[rowIndex][seatBlock[rowIndex].length - 1] = assignment++;
            }
          }
        }
      }

      rowIndex++;
    }

    return assignment;
  }

  @Override
  protected void finalize() {

    if (scanner != null) {

      scanner.close();
    }
  }

  static final class PrettyPrinter {

    private static final char BORDER_KNOT = '+';
    private static final char HORIZONTAL_BORDER = '-';
    private static final char VERTICAL_BORDER = '|';

    private static final String DEFAULT_AS_NULL = "(NULL)";

    private final PrintStream out;
    private final String asNull;

    PrettyPrinter(PrintStream out) {
      this(out, DEFAULT_AS_NULL);
    }

    PrettyPrinter(PrintStream out, String asNull) {
      if (out == null) {
        throw new IllegalArgumentException("No print stream provided");
      }
      if (asNull == null) {
        throw new IllegalArgumentException("No NULL-value placeholder provided");
      }
      this.out = out;
      this.asNull = asNull;
    }

    private String padRight(String s, int n) {
      return format("%1$-" + n + "s", s);
    }

    private String safeGet(int[] array, int index, String defaultValue) {
      return index < array.length ? String.valueOf(array[index]) : defaultValue;
    }

    public void print(int[][] table) {
      if (table == null) {
        throw new IllegalArgumentException("No tabular data provided");
      }
      if (table.length == 0) {
        return;
      }
      final int[] widths = new int[getMaxColumns(table)];
      adjustColumnWidths(table, widths);
      printPreparedTable(table, widths, getHorizontalBorder(widths));
    }

    private void printPreparedTable(int[][] table, int widths[], String horizontalBorder) {
      final int lineLength = horizontalBorder.length();
      out.println(horizontalBorder);
      for (final int[] row : table) {
        if (row != null) {
          out.println(getRow(row, widths, lineLength));
          out.println(horizontalBorder);
        }
      }
    }

    private String getRow(int[] row, int[] widths, int lineLength) {
      final StringBuilder builder = new StringBuilder(lineLength).append(VERTICAL_BORDER);
      final int maxWidths = widths.length;
      for (int i = 0; i < maxWidths; i++) {
        builder
            .append(padRight(getCellValue(safeGet(row, i, null)), widths[i]))
            .append(VERTICAL_BORDER);
      }
      return builder.toString();
    }

    private String getHorizontalBorder(int[] widths) {
      final StringBuilder builder = new StringBuilder(256);
      builder.append(BORDER_KNOT);
      for (final int w : widths) {
        for (int i = 0; i < w; i++) {
          builder.append(HORIZONTAL_BORDER);
        }
        builder.append(BORDER_KNOT);
      }
      return builder.toString();
    }

    private int getMaxColumns(int[][] rows) {
      int max = 0;
      for (final int[] row : rows) {
        if (row != null && row.length > max) {
          max = row.length;
        }
      }
      return max;
    }

    private void adjustColumnWidths(int[][] rows, int[] widths) {
      for (final int[] row : rows) {
        if (row != null) {
          for (int c = 0; c < widths.length; c++) {
            final String cv = getCellValue(safeGet(row, c, asNull));
            final int l = cv.length();
            if (widths[c] < l) {
              widths[c] = l;
            }
          }
        }
      }
    }

    private String getCellValue(Object value) {
      return value == null ? asNull : value.toString();
    }
  }
}
