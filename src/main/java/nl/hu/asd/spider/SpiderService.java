package nl.hu.asd.spider;

import nl.hu.asd.Service;
import nl.hu.asd.httpclient.IHttpClient;

import java.net.MalformedURLException;
import java.util.Set;

public class SpiderService extends Service {
    public static Set<SimpleUrl> getUrls(
            String startUrl,
            int maxChildren,
            int maxDepth,
            IHttpClient httpClient
    ) throws MalformedURLException {
        Spider spider = new Spider();
        spider.setHttpClient(httpClient);
        spider.setMaxChildren(maxChildren);
        spider.setMaxDepth(maxDepth);
        
        spider.addSeed(startUrl);

        spider.start();
        return spider.getVisitedUrls();
    }

}
