package io.github.walterinsh.basic;

import org.testng.annotations.*;

/**
 * Usually we need to initialize our test cases before we run them. For instance, setting object values,
 * creating database tables. With testng, we can initialize (also clean)them in different stages.
 *
 * Test method with annotation @BeforeClass runs before running the class(all methods).
 * Test method with annotation @BeforeMethod runs before running every method.
 *
 * Output:
 * Running code before class
 * Running code before method
 * Running test one
 * Running code after method
 * Running code before method
 * Running test two
 * Running code after method
 * Running code after class
 *
 * Here is a great answer about more before annotations and after annotation.
 * http://stackoverflow.com/questions/30587454/difference-between-beforeclass-and-beforetest-in-testng
 *
 * Created by Walter on 11/22/15.
 */
public class SetUpAndTearDownTest {

    @BeforeClass
    public void beforeClass() throws Exception {
        System.out.println("Running code before class");
    }

    @BeforeMethod
    public void beforeMethod() throws Exception {
        System.out.println("Running code before method");
    }

    @Test
    public void testOne() throws Exception {
        System.out.println("Running test one");
    }

    @Test
    public void testTwo() throws Exception {
        System.out.println("Running test two");
    }

    @AfterMethod
    public void afterMethod() throws Exception {
        System.out.println("Running code after method");
    }

    @AfterClass
    public void afterClass() throws Exception {
        System.out.println("Running code after class");
    }
}