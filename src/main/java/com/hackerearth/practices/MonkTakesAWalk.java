package com.hackerearth.practices;

/*
Today, Monk went for a walk in a garden. There are many trees in the garden and each tree has an English alphabet on it. While Monk was walking, he noticed that all trees with vowels on it are not in good state. He decided to take care of them. So, he asked you to tell him the count of such trees in the garden.
Note : The following letters are vowels: 'A', 'E', 'I', 'O', 'U' ,'a','e','i','o' and 'u'.

Input:
The first line consists of an integer T denoting the number of test cases.
Each test case consists of only one string, each character of string denoting the alphabet (may be lowercase or uppercase) on a tree in the garden.

Output:
For each test case, print the count in a new line.
*/
/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.io.PrintStream;

class MonkTakesAWalk {

    public static void main(String args[]) throws Exception {

        InputReader inputReader = new InputReader();

        PrintStream ps = new PrintStream(System.out);
        int N = inputReader.readNextInt();

        while (N-- > 0) {
            int count = 0;
            char ch = inputReader.readNextChar();

            while (!inputReader.isWhiteSpace((int) ch)) {

                switch (ch) {
                    case 'A':
                        ++count;
                        break;

                    case 'E':
                        ++count;
                        break;

                    case 'I':
                        ++count;
                        break;

                    case 'O':
                        ++count;
                        break;

                    case 'U':
                        ++count;
                        break;

                    case 'a':
                        ++count;
                        break;

                    case 'e':
                        ++count;
                        break;

                    case 'i':
                        ++count;
                        break;

                    case 'o':
                        ++count;
                        break;

                    case 'u':
                        ++count;
                        break;
                }

                ch = inputReader.readNextChar();
            }
            ps.println(count);
        }
        ps.close();

    }
}