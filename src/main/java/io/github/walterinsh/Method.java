package io.github.walterinsh;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * Util class for showing unit testing
 *
 * Created by Walter on 11/1/15.
 */
public class Method {

    public static int returnsOne() {
        return 1;
    }

    public static int shouldHaveReturnedOne() {
        return 2;
    }

    public static boolean returnsTrue() {
        return true;
    }

    public static Object returnsNull() {
        return null;
    }

    public static void onlyAcceptPositiveNum(int param) {
        if(param == 0){
            throw new IllegalArgumentException("0 is not acceptable");
        }else if(param <0) {
            throw new IllegalArgumentException("negative num is not acceptable");
        }
    }

    public static void onlyAcceptNumberString(String str) {
        if (!NumberUtils.isNumber(str)) {
            throw new IllegalArgumentException("only number strings are acceptable");
        }
    }
}
