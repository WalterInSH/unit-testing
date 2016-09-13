package io.github.walterinsh.mock;

import io.github.walterinsh.Service;
import io.github.walterinsh.ServiceImpl;
import org.mockito.AdditionalAnswers;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;

/**
 * There's a very similar method called spy(). Sometimes you can use it as mock(), sometimes not.
 * Basically spy() does not thoroughly mock your class. It calls the target's real method when you don't
 * give a "when()". But it's different when you spy an interface.
 * Created by Walter on 16-9-12.
 */
public class MockVSSpyTest {

    @Test
    public void testSimilarity() throws Exception {
        Service mockedObject = mock(Service.class);
        Service spiedObject = spy(Service.class); // equivalent to spy(new ServiceImpl());

        when(mockedObject.sayHello()).thenReturn("Hi");
        when(spiedObject.sayHello()).thenReturn("Hi");

        assertEquals(mockedObject.sayHello(), "Hi");
        assertEquals(spiedObject.sayHello(), "Hi");
    }

    /**
     * Since an interface doesn't have a real method. Thus you cannot call its real method.
     * If you call a mocked interface's method, it returns null.
     * @throws Exception
     */
    @Test
    public void testInterface() throws Exception {
        Service mockedObject = mock(Service.class);
        Service spiedObject = spy(Service.class);

        //throws a MockitoException
        //when(mockedObject.sayHello()).thenCallRealMethod();
        //when(spiedObject.sayHello()).thenCallRealMethod();

        assertEquals(mockedObject.sayHello(), null);
        assertEquals(spiedObject.sayHello(), null);
    }

    /**
     * When you mock an interface(or a Class), you can specify a default Answer as well, which
     * handles interactions you do not declare.
     * @throws Exception
     */
    @Test
    public void testInterfaceWithDefaultAnswer() throws Exception {
        Service mockedObject = mock(Service.class, AdditionalAnswers.delegatesTo(new ServiceImpl()));

        assertEquals(mockedObject.sayHello(), "hello world");

        //still throws a MockitoException
        //when(mockedObject.sayHello()).thenCallRealMethod();
    }

    @Test
    public void testClass() throws Exception {
        ServiceImpl mockedObject = mock(ServiceImpl.class);
        ServiceImpl spiedObject = spy(ServiceImpl.class);

        assertEquals(mockedObject.sayHello(), null);
        assertEquals(spiedObject.sayHello(), "hello world");

        when(mockedObject.sayHello()).thenCallRealMethod();
        assertEquals(mockedObject.sayHello(), "hello world");
    }


}
