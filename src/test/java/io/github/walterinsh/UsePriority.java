package io.github.walterinsh;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * This class shows how to use priority to control the order of tests execution.
 *
 * When we design tests, try not changing class status when tests run. Because it may affect
 * other tests. In this case, "sharedField" is the status. The first test method changes the status
 * and it affects the second test method.
 *
 * But sometimes, changing status is necessary or unavoidable. Controlling the order is important in this
 * situation.
 *
 * Mark methods with priority. Lower priorities will be scheduled first.
 *
 * Created by Walter on 11/15/15.
 */
public class UsePriority {

    @Test(priority = 1)
    public void testOne() throws Exception {
        SharedClass.sharedFiled = 2;
        assertEquals(SharedClass.sharedFiled, 2);
    }

    @Test(priority = 0)
    public void testTwo() throws Exception {
        assertEquals(SharedClass.sharedFiled, 0);
    }


}
