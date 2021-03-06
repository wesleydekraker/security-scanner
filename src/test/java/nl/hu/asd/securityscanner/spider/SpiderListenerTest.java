package nl.hu.asd.securityscanner.spider;

import nl.hu.asd.securityscanner.httpclient.HttpClientStub;
import org.junit.Test;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;

public class SpiderListenerTest
{
    @Test
    public void testStart() throws MalformedURLException {
        Spider spider = new Spider();
        SpiderListenerStub listener = new SpiderListenerStub();

        spider.addListener(listener);
        spider.setHttpClient(new HttpClientStub());

        spider.addSeed("http://example.com/index.html");
        spider.startScan();
        assertEquals(10, listener.getTotalVisitedUrls());
    }
}
