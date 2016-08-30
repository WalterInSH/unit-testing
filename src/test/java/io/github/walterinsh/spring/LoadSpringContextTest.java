package io.github.walterinsh.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * Demo loading spring framework application context.
 * Then you can have access to spring beans.
 *
 * Created by Walter on 8/13/16.
 */
@ContextConfiguration(locations = "classpath:spring/application-context.xml")
public class LoadSpringContextTest extends AbstractTestNGSpringContextTests{

    @Autowired
    private SpringBean bean;

    @Test
    public void testBeanLoaded() throws Exception {
        assertNotNull(bean);
    }
}
