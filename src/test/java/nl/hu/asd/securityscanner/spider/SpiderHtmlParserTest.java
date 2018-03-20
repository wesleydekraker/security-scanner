package nl.hu.asd.securityscanner.spider;

import static org.junit.Assert.assertEquals;

import nl.hu.asd.securityscanner.httpclient.HttpClientException;
import nl.hu.asd.securityscanner.httpclient.HttpClientStub;
import nl.hu.asd.securityscanner.httpclient.IHttpClient;
import nl.hu.asd.securityscanner.httpclient.SimpleHttpRes;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SpiderHtmlParserTest
{
    @Test
    public void testGetUrls() throws HttpClientException {
        SimpleUrl url = new SimpleUrl("http://example.com/index.html");

        IHttpClient httpClient = new HttpClientStub();
        SimpleHttpRes response = httpClient.getResource(url.toString());

        List<SimpleUrl> urls = SpiderHtmlParser.getUrls(url, response.getBody());

        List<SimpleUrl> expectedUrls = Arrays.asList(
            new SimpleUrl("http://example.com/index.html"),
            new SimpleUrl("http://example.com/london/index.html"),
            new SimpleUrl("http://example.com/paris/index.html"),
            new SimpleUrl("http://example.com/tokyo/index.html")
        );

        assertEquals(expectedUrls, urls);
    }
}
