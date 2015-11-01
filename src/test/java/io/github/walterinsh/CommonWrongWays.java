package io.github.walterinsh;

import org.testng.annotations.Test;

/**
 * Created by Walter on 11/1/15.
 */
public class CommonWrongWays {

    @Test
    public void onlyPrintTheResult() throws Exception {
        int correctResult = Method.returnsOne();
        System.out.println("My result is " + correctResult);

        int incorrectResult = Method.shouldHaveReturnedOne();
        System.out.println("My result is " + incorrectResult);
    }
}
