package nl.hu.asd.spider;

import nl.hu.asd.Service;
import nl.hu.asd.httpclient.IHttpClient;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class SpiderService extends Service {
    private static Map<String, Spider> spiders = new HashMap<>();

    private SpiderService() { }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static void startScan(
            String id,
            String startUrl,
            int maxChildren,
            int maxDepth,
            IHttpClient httpClient
    ) throws MalformedURLException {
        if (id.length() != 36) {
            throw new IllegalArgumentException();
        }

        Spider spider = new Spider();
        spiders.put(id, spider);

        spider.setHttpClient(httpClient);
        spider.setMaxChildren(maxChildren);
        spider.setMaxDepth(maxDepth);
        
        spider.addSeed(startUrl);

        spider.startScan();
    }

    public static Set<SimpleUrl> getVisitedUrls(String id) {
        return spiders.get(id).getVisitedUrls();
    }

}
