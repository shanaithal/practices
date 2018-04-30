package com.hackerearth.practices.util;

import java.util.List;

/**
 * @author I311197
 */
public final class ArrayUtil {

    private ArrayUtil() {

        throw new UnsupportedOperationException();
    }

    public static boolean isSorted(final List<Integer> array) {

        for (int i = 0; i < array.size() - 1; i++) {

            if (array.get(i) > array.get(i + 1)) {

                return false;
            }
        }

        return true;
    }
}
