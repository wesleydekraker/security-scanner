package nl.hu.asd.httpclient;

import org.junit.Test;

public class HttpClientStubTest
{
    @Test
    public void testGet() throws HttpClientException {
        HttpClientStub httpClientStub = new HttpClientStub();

        SimpleHttpRes response = httpClientStub.connect("http://example.com/tokyo/index.html");
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
    }
}