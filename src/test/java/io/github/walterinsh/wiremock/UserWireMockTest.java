package io.github.walterinsh.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.testng.Assert.assertEquals;

/**
 * 有时由于设计原因,无法将必须要的步骤mock, 对于http api的依赖,就可以使用WireMock来解决.
 * WireMock的思想无出其右,可以看做更外层的mock. 简单解释其原理就是:
 * 真实的在本地启动一个http server, 你可以方便的指定一些接口,包括请求的path, body等,
 * 也包括响应的status code, body等.
 *
 * 单元测试时更改接口的host,指向wire mock server, 便可以随意控制接口交互
 *
 * Created by Walter on 8/21/16.
 */
public class UserWireMockTest {

    WireMockServer wireMockServer;

    HttpAPIService httpAPIService = new HttpAPIService();

    @BeforeTest
    public void setUp() throws Exception {
        wireMockServer = new WireMockServer();

        wireMockServer.start();
    }

    @Test
    public void testRequestDataShouldSucceed() throws Exception {
        stubFor(get(urlEqualTo("/api"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"data\":123456}")));

        String data = httpAPIService.requestData();
        assertEquals(data, "{\"data\":123456}");
    }

    @Test
    public void testRequestDataShouldFailed() throws Exception {
        stubFor(get(urlEqualTo("/api"))
                .willReturn(aResponse()
                        .withStatus(500)));

        String data = httpAPIService.requestData();
        assertEquals(data, "");
    }

    @AfterTest
    public void tearDown() throws Exception {
        wireMockServer.stop();
    }
}