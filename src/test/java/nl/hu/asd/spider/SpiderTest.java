package nl.hu.asd.spider;

import nl.hu.asd.httpclient.HttpClientStub;
import org.junit.Test;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;

public class SpiderTest
{
    @Test
    public void testStart() throws MalformedURLException {
        Spider spider = new Spider();
        spider.setHttpClient(new HttpClientStub());

        spider.start("http://example.com/index.html");
        assertEquals(10, spider.getVisitedUrls().size());
    }

    @Test
    public void testStartMaxDepth() throws MalformedURLException {
        Spider spider = new Spider();
        spider.setHttpClient(new HttpClientStub());
        spider.setMaxDepth(4);

        spider.start("http://example.com/index.html");
        assertEquals(9, spider.getVisitedUrls().size());
    }

    @Test
    public void testStartMaxChildren() throws MalformedURLException {
        Spider spider = new Spider();
        spider.setHttpClient(new HttpClientStub());
        spider.setMaxChildren(1);

        spider.start("http://example.com/index.html");
        assertEquals(6, spider.getVisitedUrls().size());
    }
}
