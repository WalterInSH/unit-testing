package io.github.walterinsh.wiremock;

import org.apache.http.client.fluent.Request;

/**
 * Created by Walter on 8/21/16.
 */
public class HttpAPIService {

    //this's the api url, we usually load it from a property file.
    //you can use two different property file for production and unit tests
    //to keep this example simple, we just declare it directly.
    private String apiUrl = "http://127.0.0.1:8080/api";

    public String requestData() throws Exception {
        try {
            //Note: you cannot easily mock the Request
            return Request.Get(apiUrl)
                    .execute().returnContent().asString();
        } catch (Exception e) {
            //if cannot get data from remote server, then return default data("")
            return "";
        }
    }
}
