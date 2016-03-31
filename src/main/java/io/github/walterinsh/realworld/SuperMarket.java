package io.github.walterinsh.realworld;

import java.net.SocketTimeoutException;

/**
 * Created by Walter on February/4/16.
 */
public class SuperMarket {

    private static final float DEFAULT_DISCOUNT = 1f;
    private static final int MAX_RETRY = 1;

    private PriceList priceList = new PriceList();
    private HttpDiscountService httpDiscountService = new HttpDiscountService();

    public float buy(int productId) {
        if (productId<=0) {
            throw new IllegalArgumentException("invalid product id");
        }

        float price = priceList.getPrice(productId);
        float discount = DEFAULT_DISCOUNT;

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
