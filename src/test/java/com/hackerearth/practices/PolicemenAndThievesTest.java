package com.hackerearth.practices;

import com.hackerearth.practices.util.FileUtil;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author I311197
 */
public class PolicemenAndThievesTest {

    @Test
    public void testCalculate() {

        try {

            InputReader inputReader = new InputReader(FileUtil.fetchFileContentAsStream("./src/test/resources/police_and_thieves.txt"));
            assertEquals(319, getPolicemenAndThieves(inputReader).calculate());
        } catch (IOException e) {

            fail(e.getMessage());
        }
    }

    private PolicemenAndThieves getPolicemenAndThieves(InputReader inputReader) {
        return new PolicemenAndThieves(inputReader, null);
    }
}