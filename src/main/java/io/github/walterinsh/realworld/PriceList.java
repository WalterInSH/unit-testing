package io.github.walterinsh.realworld;

/**
 * Created by Walter on February/4/16.
 */
public class PriceList {

    /**
     * Let's assume that a product's price is product id multiplies 3.5
     * @param productId
     * @return
     */
    public float getPrice(int productId){
        return productId * 3.5f;
    }
}
