package io.github.walterinsh.basic;

import io.github.walterinsh.Method;
import org.testng.annotations.Test;

/**
 * Some common mistakes I've seen.
 *
 * Created by Walter on 11/1/15.
 */
public class CommonWrongWaysTest {
    /**
     * Only printing your test results is not good enough.
     *
     * Although it tells whether your code falls, but you have to check it by
     * reading your testing log. It's really not a good idea to point out your results
     * from a 10-page log.
     *
     * Even though you're fast, but don't let the machines do your work?
     * Assertion is what you're looking for!
     * @throws Exception
     */
    @Test
    public void onlyPrintTheResult() throws Exception {
        int correctResult = Method.returnsOne();
        System.out.println("My result is " + correctResult);

        int incorrectResult = Method.shouldHaveReturnedOne();
        System.out.println("My result is " + incorrectResult);
    }
}
