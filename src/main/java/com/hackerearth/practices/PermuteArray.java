package com.hackerearth.practices;

import java.util.*;

/**
 * @author I311197
 */
public class PermuteArray {

    public static int counter = 0;

    private static Set<List<Integer>> lists = new HashSet<>(new ArrayList<>(1));

    public static void permute(List<Integer> input, int startindex) {
        int size = input.size();

        if (size == startindex + 1) {
            System.out.println(counter + "Permutation is");
            for (int i = 0; i < size; i++) {
                System.out.print(input.get(i) + ",  ");
                lists.add(input);
            }
            System.out.println();
            System.out.println("##########################");
            counter++;
        } else {
            for (int i = startindex; i < size; i++) {

                Collections.swap(input, i, startindex);
                permute(input, startindex + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input array Length");
        int arraylength = in.nextInt();
        List<Integer> input = new ArrayList<>(arraylength);
        for (int i = 0; i < arraylength; i++) {
            input.add(in.nextInt());
        }
        counter = 0;
        permute(input, 0);
        System.out.println(counter + "  number of permutations obtained");
    }
}