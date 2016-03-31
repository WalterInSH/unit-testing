package io.github.walterinsh.realworld;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.testng.annotations.Test;

import java.net.SocketTimeoutException;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

/**
 * Created by Walter on February/4/16.
 */
public class SuperMarketTest {

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "invalid product id")
    public void testIllegalProductId() throws Exception {
        new SuperMarket().buy(-1);
    }

    @Test
    public void testNormalProcedure() throws Exception {
        float price = new SuperMarket().buy(10);

        // 10 * 3.5 / 2 = 17.5
        assertEquals(price, 17.5f);
    }

    @Test
    public void testDisconnection() throws Exception {
        SuperMarket superMarket = new SuperMarket();
        HttpDiscountService mockedHttpDiscountService = mock(HttpDiscountService.class);
        FieldUtils.writeField(superMarket, "httpDiscountService", mockedHttpDiscountService, true);

        when(mockedHttpDiscountService.getDiscountFromRemoteService()).thenThrow(new SocketTimeoutException());

        float price = superMarket.buy(10);

        // 10 * 3.5 * 1 = 35
        assertEquals(price, 35f);
        verify(mockedHttpDiscountService, times(2)).getDiscountFromRemoteService();
    }

    @Test
    public void testNetworkFluctuation() throws Exception {
        SuperMarket superMarket = new SuperMarket();
        HttpDiscountService mockedHttpDiscountService = mock(HttpDiscountService.class);
        FieldUtils.writeField(superMarket, "httpDiscountService", mockedHttpDiscountService, true);

        when(mockedHttpDiscountService.getDiscountFromRemoteService())
                .thenThrow(new SocketTimeoutException())
                .thenCallRealMethod();

        float price = superMarket.buy(10);

        // 10 * 3.5 * 0.5 = 17.5
        assertEquals(price, 17.5f);
        verify(mockedHttpDiscountService, times(2)).getDiscountFromRemoteService();
    }
}