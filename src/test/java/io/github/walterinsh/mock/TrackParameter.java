package io.github.walterinsh.mock;

import org.mockito.ArgumentCaptor;
import org.testng.annotations.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertEquals;

/**
 * Sometimes we need to know what were passed to a method. Are the parameters really what you expected?
 * ArgumentCaptor is something can help.
 *
 * Created by Walter on 12/4/15.
 */
public class TrackParameter {

    /**
     * We are going to verify we really passed the right parameter to the class.
     * This is a little weird on the sample. We'll see some real world examples later on.
     * But first I want to demonstrate the syntax.
     *
     * @throws Exception
     */
    @Test
    public void trackParam() throws Exception {
        ArgumentCaptor<CharSequence> captor = ArgumentCaptor.forClass(CharSequence.class);
        TargetClass targetClass = mock(TargetClass.class);

        targetClass.targetMethod("parameter");

        verify(targetClass).targetMethod(captor.capture());

        List<CharSequence> capturedValues = captor.getAllValues();
        assertEquals(capturedValues.get(0), "parameter");
    }

    class TargetClass {

        public void targetMethod(CharSequence argument) {

        }
    }

}
