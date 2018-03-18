package nl.hu.asd;

import nl.hu.asd.httpclient.HttpClientException;
import nl.hu.asd.httpclient.HttpClientStub;
import nl.hu.asd.httpclient.SimpleHttpRes;
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
