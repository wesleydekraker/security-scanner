package nl.hu.asd.httpclient;

import nl.hu.asd.httpclient.HttpClient;
import nl.hu.asd.httpclient.HttpClientException;
import nl.hu.asd.httpclient.SimpleHttpRes;
import org.junit.Test;

public class HttpClientTest
{
    @Test
    public void testGet() throws HttpClientException {
        HttpClient httpClient = new HttpClient();

        SimpleHttpRes response = httpClient.connect("http://example.com/");

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
    }
}
