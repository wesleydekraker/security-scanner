package nl.hu.asd.spider;

import nl.hu.asd.Service;
import nl.hu.asd.httpclient.IHttpClient;
import nl.hu.asd.persistence.ISpiderRepository;
import nl.hu.asd.persistence.SpiderRepository;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.UUID;

public class SpiderService extends Service {
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

        Spider spider = new Spider();

        spider.setSpiderId(new SpiderId(id));
        spider.setHttpClient(httpClient);
        spider.setMaxChildren(maxChildren);
        spider.setMaxDepth(maxDepth);
        
        spider.addSeed(startUrl);

        spider.startScan();

        ISpiderRepository spiderRepository = new SpiderRepository();
        spiderRepository.save(spider);
    }

    public static Set<SimpleUrl> getVisitedUrls(String id) {
        ISpiderRepository spiderRepository = new SpiderRepository();
        return spiderRepository.get(new SpiderId(id)).getVisitedUrls();
    }

}
