package io.github.walterinsh.mock;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.net.SocketTimeoutException;

import static org.mockito.Mockito.doThrow;

/**
 * Sometimes, we need to throw an exception when we testing our code. Throw a SQLException to simulate database
 * problems. Throw a SocketTimeOutException to simulate network problems,etc.
 *
 * Created by Walter on 11/29/15.
 */
public class ThrowAnExceptionTest {

    /**
     * Now, let's pretend that our code calls a remote api, we want to test bad network situation.
     * We force the target method to throw a SocketTimeoutException.
     * @throws Exception
     */
    @Test(expectedExceptions = SocketTimeoutException.class,
            expectedExceptionsMessageRegExp = "no response")
    public void throwAnException() throws Exception {
        HttpService httpService = Mockito.mock(HttpService.class);

        doThrow(new SocketTimeoutException("no response")).when(httpService).callRemoteAPI();

        httpService.callRemoteAPI();//throws an exception
    }

    class HttpService {

        public void callRemoteAPI() throws Exception{}
    }
}


