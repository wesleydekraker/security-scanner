package nl.hu.asd.spider;

import nl.hu.asd.httpclient.HttpClientStub;
import org.junit.Test;

import java.net.MalformedURLException;

public class SpiderControllerTest
{
    @Test
    public void testConstructor() throws MalformedURLException {
        SpiderController spiderController = new SpiderController();
        spiderController.setHttpClient(new HttpClientStub());
        spiderController.setMaxChildren(4);
        spiderController.setMaxDepth(5);

        spiderController.start("http://example.com/index.html");
        System.out.println(spiderController.getVisitedUrls());
    }
}
