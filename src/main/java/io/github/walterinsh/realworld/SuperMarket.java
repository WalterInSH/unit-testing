package io.github.walterinsh.realworld;

import java.net.SocketTimeoutException;

/**
 * Let's say we own a supermarket where we sale things. We should know the price when customers check out.
 * It's tricky that the price of a product is product id multiplies 3.5. We also offer a discount for each customer.
 * Additional, we need to fetch discount rate from HQ server which is a http API. This step could fail due to bad network.
 *
 * Here's the class we need to test.It has a checkout method which takes product id and returns the final price.
 *
 * Created by Walter on February/4/16.
 */
public class SuperMarket {

    private static final float DEFAULT_DISCOUNT = 1f;
    private static final int MAX_RETRY = 1;

    private PriceList priceList = new PriceList();
    private HttpDiscountService httpDiscountService = new HttpDiscountService();

    public float checkout(int productId) {
        if (productId<=0) {
            throw new IllegalArgumentException("invalid product id");
        }

        float price = priceList.getPrice(productId);
        float discount = DEFAULT_DISCOUNT;

        //Fetch discount rate from remote server. In case of network error, we try one more time.
        //If we still cannot get discount rate, it's fine to use default rate(no discount).
        int count = 0;
        while(true) {
            try {
                discount = httpDiscountService.getDiscountFromRemoteService();
            } catch (SocketTimeoutException e) {
                if (count++ < MAX_RETRY) continue;
            }
            break;
        }

        return price * discount;
    }

}
