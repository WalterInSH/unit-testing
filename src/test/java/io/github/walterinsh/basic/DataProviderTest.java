package io.github.walterinsh.basic;

import io.github.walterinsh.Method;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @DataProvder supplies data for tests. And it saves your code and gives more readabilities.
 * Created by Walter on 16-9-5.
 */
public class DataProviderTest {

    @DataProvider(name = "number set")
    public Object[][] numberSet(){
        return new Object[][] {
                {"-1"},
                {"123"},
                {"1.1"}};
    }

    @DataProvider
    public Object[][] wordSet(){
        return new Object[][] {
                {"A"},
                {"1.1.1.1"}};
    }

    @Test(dataProvider = "number set")
    public void testWithNumberStringShouldNoException(String preparedData) throws Exception {
        Method.onlyAcceptNumberString(preparedData);
    }

    //use default data provider's name(method name)
    @Test(dataProvider = "wordSet", expectedExceptions = IllegalArgumentException.class)
    public void testWithIllegalStringShouldFail(String preparedData) throws Exception {
        Method.onlyAcceptNumberString(preparedData);
    }
}
