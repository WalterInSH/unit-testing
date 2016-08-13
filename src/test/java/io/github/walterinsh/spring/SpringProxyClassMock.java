package io.github.walterinsh.spring;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.util.AopTestUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * There is a trap when you testing spring beans if you use AOP.
 * You will get a proxy bean so you cannot find the field you expected.
 * AopTestUtils.getTargetObject() helps you to find the field, then you
 * can do the rest(eg. mock the field).
 *
 * Created by Walter on 8/13/16.
 */
@ContextConfiguration(locations = "classpath:spring/application-context.xml")
public class SpringProxyClassMock extends AbstractTestNGSpringContextTests{

    @Autowired
    private AOPSpringBean bean;

    @Test
    public void testBeanLoaded() throws Exception {
        assertNotNull(bean);

        //This field wouldn't be found because the bean is a spring proxy bean,
        //not a real AOPSpringBean instance.
        assertNull(FieldUtils.readField(bean, "fieldNeedMocked", true));

        //If you want to mock or replace a field, get the target object first.
        AOPSpringBean realBean = AopTestUtils.getTargetObject(bean);
        assertNotNull(FieldUtils.readField(realBean, "fieldNeedMocked", true));

        FieldUtils.writeField(realBean, "fieldNeedMocked", "woo", true);
        assertEquals(bean.run(), "woo");
    }
}
