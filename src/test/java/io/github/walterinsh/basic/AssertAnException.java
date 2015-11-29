package io.github.walterinsh.basic;

import io.github.walterinsh.Method;
import org.testng.annotations.Test;

/**
 * How to assert methods which expected throws an exception?
 *
 * "expectedExceptions" is the answer!
 *
 * Created by Walter on 11/8/15.
 */
public class AssertAnException {

    /**
     * If not throwing an exception means this method works fine.
     * Just invoke it!
     *
     * (But to most of situations this is not good enough.)
     * @throws Exception
     */
    @Test
    public void assertCorrectUse() throws Exception {
        Method.onlyAcceptPositiveNum(1);
    }

    /**
     * Sometimes we offer an incorrect parameter to a method to see if it can
     * throws an exception as we expected.
     *
     * Just do it this way.
     * @throws Exception
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void expectAnException() throws Exception {
        Method.onlyAcceptPositiveNum(-1);
    }

    /**
     * Sometimes asserting an exception is also not specific enough. Because
     * a method could throw an exception with different reasons. Asserting the
     * message is necessary.
     * 
     * @throws Exception
     */
    @Test(expectedExceptions = IllegalArgumentException.class,
        expectedExceptionsMessageRegExp = "negative num is not acceptable")
    public void expectAnExceptionWithAMessage() throws Exception {
        Method.onlyAcceptPositiveNum(-1);
    }
}
