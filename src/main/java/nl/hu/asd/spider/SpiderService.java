package nl.hu.asd.spider;

import nl.hu.asd.Service;
import nl.hu.asd.httpclient.HttpClient;

import java.net.MalformedURLException;
import java.util.Set;

public class SpiderService extends Service {
    public static Set<SimpleUrl> getUrls(String startUrl, int maxChildren, int maxDepth) throws MalformedURLException {
        Spider spider = new Spider();
        spider.setHttpClient(new HttpClient());
        spider.setMaxChildren(maxChildren);
        spider.setMaxDepth(maxDepth);

        spider.start(startUrl);
        return spider.getVisitedUrls();
    }

}
