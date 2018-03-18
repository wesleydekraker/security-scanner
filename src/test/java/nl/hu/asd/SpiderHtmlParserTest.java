package nl.hu.asd;

import static org.junit.Assert.assertEquals;

import nl.hu.asd.httpclient.HttpClientException;
import nl.hu.asd.httpclient.HttpClientStub;
import nl.hu.asd.httpclient.IHttpClient;
import nl.hu.asd.httpclient.SimpleHttpRes;
import nl.hu.asd.spider.SimpleUrl;
import nl.hu.asd.spider.SpiderHtmlParser;
import org.junit.Test;

import java.util.List;

public class SpiderHtmlParserTest
{
    @Test
    public void testGetLinks() throws HttpClientException {
        SimpleUrl url = new SimpleUrl("http://example.com/index.html");

        IHttpClient httpClient = new HttpClientStub();
        SimpleHttpRes response = httpClient.connect(url.toString());

        SpiderHtmlParser spiderHtmlParser = new SpiderHtmlParser();
        List<SimpleUrl> links = spiderHtmlParser.getUrls(url, response.getBody());

        for (SimpleUrl link : links) {
            System.out.println(link);
        }

        assertEquals(4, links.size());
    }
}
