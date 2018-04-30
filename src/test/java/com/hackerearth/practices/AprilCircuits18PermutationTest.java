package com.hackerearth.practices;

import com.hackerearth.practices.util.FileUtil;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author I311197
 */
public class AprilCircuits18PermutationTest {

    @Test
    public void testCalculate() {

        try {

            InputReader inputReader =
                    new InputReader(
                            FileUtil.fetchFileContentAsStream(
                                    "./src/test/resources/april_circuit18_permutation.txt"));
            assertEquals(2, getAprilCircuits18Permutation(inputReader).calculate());
        } catch (IOException e) {

            fail(e.getMessage());
        }
    }

    private AprilCircuits18Permutation getAprilCircuits18Permutation(InputReader inputReader) {

        return new AprilCircuits18Permutation(inputReader);
    }
}
