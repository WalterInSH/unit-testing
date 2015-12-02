package io.github.walterinsh.mock;

import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

/**
 * Usually, we want to know more about our mocked objects. The number of how many times our object has been invoked is
 * important under some circumstances. It helps us to know what really happened underlying.
 * Created by Walter on 12/2/15.
 */
public class TrackInvocation {

    /**
     * With Mockito.verify() and some special asserts(times, atLeast, atMost, never), we can reinforce our unit tests.
     * @throws Exception
     */
    @Test
    public void trackInvocationTimes() throws Exception {
        TargetClass targetClass = mock(TargetClass.class);

        targetClass.targetMethod(null);
        targetClass.targetMethod("A");
        targetClass.targetMethod("A");
        targetClass.targetMethod("B");

        verify(targetClass, times(2)).targetMethod("A");
        verify(targetClass, times(1)).targetMethod("B");
        verify(targetClass, times(4)).targetMethod(anyString());

        verify(targetClass, atLeast(2)).targetMethod("A");
        verify(targetClass, atLeastOnce()).targetMethod("B");

        verify(targetClass, atMost(1)).targetMethod("B");

        verify(targetClass, never()).targetMethod("C");
    }

    /**
     * If you want to ensure there are no more interactions(invocations) except what you need.
     * Mockito.verifyNoMoreInteractions might help.
     *
     * @throws Exception
     */
    @Test
    public void noMoreInvocations() throws Exception {
        TargetClass targetClass = mock(TargetClass.class);

        // one interaction should happen
        targetClass.targetMethod(null);

        /*
            The next commented code should not have happened. If you uncomment the code, the test fails,and with this
            friendly information

            For your reference, here is the list of all invocations ([?] - means unverified).
            1. -> at io.github.walterinsh.mock.TrackInvocation.noMoreInvocations(TrackInvocation.java:50)
            2. [?]-> at io.github.walterinsh.mock.TrackInvocation.noMoreInvocations(TrackInvocation.java:60)
        */
        // targetClass.targetMethod("");

        verify(targetClass, times(1)).targetMethod(null);
        verifyNoMoreInteractions(targetClass);
    }

    class TargetClass {

        public void targetMethod(String param) {}
    }
}
