package io.github.walterinsh.bdd;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Walter on 16-8-30.
 */
public class StringReverser {

    private boolean uppercase;

    public StringReverser(boolean uppercase) {
        this.uppercase = uppercase;
    }

    public String inverse(String s){
        String reverseS = StringUtils.reverse(s);
        return uppercase ? reverseS.toUpperCase() : reverseS;
    }

}
