package io.github.walterinsh.basic;

import io.github.walterinsh.Method;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Some basic assertion examples.
 *
 * Assert throws an exception when your code falls. Then testing framework reports
 * them to you. It's easier and fully automatically!
 *
 * Created by Walter on 11/4/15.
 */
public class BasicAssertionTest {

    @Test
    public void exampleOne() throws Exception {
        Assert.assertNull(Method.returnsNull());
        
        Assert.assertTrue(Method.returnsTrue());
        Assert.assertFalse(!Method.returnsTrue());

        Assert.assertEquals(Method.returnsOne(), 1);
        Assert.assertNotEquals(Method.returnsOne(), 2);
    }

    @Test
    public void useStaticImport() throws Exception {
        assertNull(Method.returnsNull());

        assertTrue(Method.returnsTrue());
        assertFalse(!Method.returnsTrue());

        assertEquals(Method.returnsOne(), 1);
        assertNotEquals(Method.returnsOne(), 2);
    }
}
