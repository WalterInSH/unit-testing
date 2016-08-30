package io.github.walterinsh.mock;

import org.apache.commons.lang3.StringUtils;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.testng.annotations.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

/**
 * Mock objects help you control a class's specific behavior, so that you can design
 * a specific test scenario.First we need to know how to control a class. Why don't we start
 * with changing return values.
 *
 * We use mockito to demonstrate.
 * Created by Walter on 11/29/15.
 */
public class ControlReturnValueTest {
    /**
     * Originally, target method always returns " ".
     * @throws Exception
     */
    @Test
    public void originalBehavior() throws Exception {
        TargetClass targetClass = new TargetClass();
        assertEquals(targetClass.targetMethod("")," ");
    }

    /**
     * But we are going to change its return value with mockito.
     * @throws Exception
     */
    @Test
    public void controlReturnValues() throws Exception {
        TargetClass targetClass = Mockito.mock(TargetClass.class);

        Mockito.when(targetClass.targetMethod("")).thenCallRealMethod();
        assertEquals(targetClass.targetMethod(""), " ");

        //it means: when we invoke the method with parameter "", it should return "A".
        Mockito.when(targetClass.targetMethod("")).thenReturn("A");
        assertEquals(targetClass.targetMethod(""), "A");

        //we can rewrite the code by changing the order of when part and return part
        Mockito.doReturn("B").when(targetClass).targetMethod("");
        assertEquals(targetClass.targetMethod(""), "B");
    }

    /**
     * We can manipulate the target method with different situations. For example, different parameters.
     * @throws Exception
     */
    @Test
    public void controlReturnValuesBasedOnParam() throws Exception {
        TargetClass targetClass = Mockito.mock(TargetClass.class);

        //use a static import to simplify codes
        when(targetClass.targetMethod("a")).thenReturn("A");
        when(targetClass.targetMethod("b")).thenReturn("B");

        assertEquals(targetClass.targetMethod("a"), "A");
        assertEquals(targetClass.targetMethod("b"), "B");
    }

    /**
     * We can customize the return result with the help of an interface called Answer.
     *
     * Here we use a special method called anyString(). That means this method should return specific value
     * regardless of what parameter is given. We'll explain this more detailed later on.
     * @throws Exception
     */
    @Test
    public void useAnswerInterface() throws Exception {
        TargetClass targetClass = Mockito.mock(TargetClass.class);

        when(targetClass.targetMethod(anyString())).thenAnswer(new Answer<String>() {
            public String answer(InvocationOnMock invocation) throws Throwable {
                boolean isNumeric = StringUtils.isNumeric(invocation.getArguments()[0].toString());
                if (isNumeric) {
                    return "numeric string";
                } else {
                    return "not numeric string";
                }
            }
        });

        assertEquals(targetClass.targetMethod("E"), "not numeric string");
        assertEquals(targetClass.targetMethod("123"), "numeric string");
    }

    /**
     * TargetClass is a class has a method called targetMethod. It always returns a space.
     */
    class TargetClass {

        public String targetMethod(String param) {
            return " ";
        }
    }
}


