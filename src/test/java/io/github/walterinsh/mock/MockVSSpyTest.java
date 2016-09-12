package io.github.walterinsh.mock;

import io.github.walterinsh.Service;
import io.github.walterinsh.ServiceImpl;
import org.mockito.AdditionalAnswers;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;

/**
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

    @Test
    public void testInterfaceWithDefaultAnwser() throws Exception {
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
