package nl.hu.asd.securityscanner.spider;

import nl.hu.asd.securityscanner.Service;
import nl.hu.asd.securityscanner.persistence.ISpiderRepository;

import java.net.MalformedURLException;
import java.util.Set;

public class SpiderService extends Service {
    private static ISpiderFactory factory = new SpiderFactory();

    private SpiderService() { }

    public static String generateId() {
        ISpiderRepository spiderRepository = factory.createSpiderRepository();
        return spiderRepository.nextId().toString();
    }

    public static void startScan(
            String id,
            String startUrl,
            int maxChildren,
            int maxDepth
    ) throws MalformedURLException {

        Spider spider = new Spider();

        spider.setHttpClient(factory.createHttpClient());

        spider.setSpiderId(new SpiderId(id));
        spider.setMaxChildren(maxChildren);
        spider.setMaxDepth(maxDepth);
        
        spider.addSeed(startUrl);

        spider.startScan();

        ISpiderRepository spiderRepository = factory.createSpiderRepository();
        spiderRepository.save(spider);
    }

    public static Set<SimpleUrl> getVisitedUrls(String id) {
        ISpiderRepository spiderRepository = factory.createSpiderRepository();
        return spiderRepository.get(new SpiderId(id)).getVisitedUrls();
    }

    public static void setFactory(ISpiderFactory factory) {
        SpiderService.factory = factory;
    }

}
