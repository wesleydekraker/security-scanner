package nl.hu.asd.httpclient;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HttpClientStubTest
{
    @Test
    public void testGet() throws HttpClientException {
        HttpClientStub httpClientStub = new HttpClientStub();

        SimpleHttpRes response = httpClientStub.getResource("http://example.com/tokyo/map.html");
        assertEquals(200, response.getStatusCode());
        assertTrue(response.getBody().contains("Map of Tokyo"));
    }
}
