package io.github.walterinsh.realworld;

/**
 * Created by Walter on February/4/16.
 */
public class SuperMarket {

    private PriceList priceList;

    public boolean buy(int productId) {
        if (productId<=0) {
            throw new IllegalArgumentException("invalid product id");
        }

        float price = priceList.getPrice(productId);

        return false;
    }

}
