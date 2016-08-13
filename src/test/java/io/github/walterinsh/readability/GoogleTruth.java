package io.github.walterinsh.readability;

import io.github.walterinsh.Method;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static com.google.common.truth.Truth.assertThat;

/**
 * Google Truth 是一个让断言更易读的框架,同时提供了更友好的报错信息.
 * (在例子中可以人为的让单元测试不通,看一下报错信息)
 *
 * 获取更多关于Google Truth: http://google.github.io/truth/
 * Created by Walter on 4/23/16.
 */
public class GoogleTruth {

    @Test
    public void assertNull() throws Exception {
        assertThat(Method.returnsNull()).isNull();
    }


    @Test
    public void assertEquality() throws Exception {
        assertThat(Method.returnsOne()).isEqualTo(1);
        assertThat(Method.returnsOne()).isNotEqualTo(2);

        assertThat(Method.returnsOne()).isNoneOf(2,3);
    }

    @Test
    public void comparison() throws Exception {
        assertThat(Method.returnsOne()).isAtLeast(0);
        assertThat(Method.returnsOne()).isGreaterThan(0);

        assertThat(Method.returnsOne()).isAtMost(2);
        assertThat(Method.returnsOne()).isLessThan(2);
    }

    @Test
    public void listSupport() throws Exception {
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(2);
        }};

        assertThat(integerArrayList).hasSize(3);

        assertThat(integerArrayList).contains(2);
        assertThat(integerArrayList).isNoneOf(3,4);

        assertThat(integerArrayList).isOrdered();
    }

    @Test
    public void mapSupport() throws Exception {
        HashMap<String, String> levelMap = new HashMap<String, String>() {{
            put("Jim", "Level 1");
            put("Tom", "Level 2");
        }};

        assertThat(levelMap).hasSize(2);

        assertThat(levelMap).containsKey("Jim");
        assertThat(levelMap).containsEntry("Jim", "Level 1");
    }
}
