package hackerearth;

import java.util.Scanner;

/**
 * FizzBuzz
 *
 * <p>Write a program that prints the numbers in the given range. But for multiples of three print
 * “Fizz” instead of the number and for the multiples of five print “Buzz”. For numbers which are
 * multiples of both three and five print “FizzBuzz”. Print a new line after each string or number.
 *
 * <p>Input Format First line will be the number of testcases, T. Next line will have T integers,
 * denoted by N.
 *
 * <p>Output Format For each testcase, print the number from 1 to N. But follow the rules given in
 * the problem statement.
 *
 * <p>Constraints
 *
 * <p>1 <= T <= 10
 *
 * <p>N is an integer.
 *
 * <p>Please read the below instructions carefully
 *
 * <p>You can choose any language from the given list to write your solution. All input to the
 * programming solution is to STDIN and output is to STDOUT. You don't have to manually give the
 * input to your program, just take the input from STDIN and the code evaluation engine will provide
 * the input to your program. For example if you are coding in C, and the first input is an integer
 * then simply do scanf('%d', &i) assuming you are reading that integer to a variable named i.
 * Similarly if you are using C++ simply do cin >> i There are two different type of test cases.
 * First type is the sample input and output for which you know both the input and output. You can
 * look at them under the problem statement. When you click Compile and Test the code will be
 * compiled and tested only on the sample input that is shown to you. Compile and Test is for you to
 * understand if you solution is compiling and running against the sample input. 5 When you click
 * submit, your code will be judged on multiple test cases which are hidden. These tests are not
 * available for you to see them so you will not know the input on which your code will be tested.
 * But it is assured that all inputs will be in the given constraint limit and in the given format
 * as stated in the problem statement. In order for your code to get accepted, it must clear all the
 * judge test cases. In cases where partial marking is allowed, you will awarded partial marks for
 * the number of test cases your solution passes. Please note that getting green mark when you hit
 * 'Compile and Test' does not indicate anything on the correctness of your program. It just
 * indicates that your code correctly compiled and ran successfully against the sample input. It can
 * still fail for other test inputs that visible to you. Do not output anything, except what it is
 * asked for in the output section. Note that you have to output only in the way that is mentioned.
 * Any extra strings in the output will be treated as wrong answer. Even an extra space can lead to
 * the answer not being accepted. Don't assume any constraints on the input based on the sample
 * input that you see, the actual test cases will be much larger in size. But they will always be
 * within the constraints mentioned in the problem. To understand how the code is evaluated visit
 * the judge page. There is also a sample code in each language there.
 *
 * <p>To further understand how the judge works, look at one of the actual test input file and the
 * corresponding expected output for this problem
 */
class FizzBuzz {
  public static void main(String args[]) {

    // Scanner
    Scanner scanner = new Scanner(System.in, "UTF-8");
    int numberOfTestcases = scanner.nextInt(); // Reading input from STDIN

    while (numberOfTestcases-- > 0) {

      int integer = scanner.nextInt();
      for (int number = 1; number <= integer; number++) {

        if (number % 3 == 0) {

          if (number % 5 == 0) {

            System.out.println("FizzBuzz");
          } else {

            System.out.println("Fizz");
          }
        } else if (number % 5 == 0) {

          System.out.println("Buzz");
        } else {

          System.out.println(number);
        }
      }
    }
  }
}
