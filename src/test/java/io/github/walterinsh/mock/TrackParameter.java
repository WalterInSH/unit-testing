package io.github.walterinsh.mock;

import org.mockito.ArgumentCaptor;
import org.testng.annotations.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertEquals;

/**
 * Created by Walter on 12/4/15.
 */
public class TrackParameter {

    @Test
    public void trackParam() throws Exception {
        ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
        CharSequence argument = mock(CharSequence.class);

        new TargetClass().targetMethod(argument);

        verify(argument).subSequence(captor.capture(), captor.capture());

        List<Integer> capturedValues = captor.getAllValues();
        assertEquals(capturedValues.get(0).intValue(), 1);
        assertEquals(capturedValues.get(1).intValue(), 4);
    }

    class TargetClass {

        public void targetMethod(CharSequence argument) {
            argument.subSequence(1, 4);
        }
    }

}
