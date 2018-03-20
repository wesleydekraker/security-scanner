package nl.hu.asd.securityscanner.persistence;

import nl.hu.asd.securityscanner.spider.Spider;
import nl.hu.asd.securityscanner.spider.SpiderId;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class SpiderRepository implements ISpiderRepository {
    private static Set<Spider> spiders = new HashSet<>();

    public Spider get(SpiderId spiderId) {
        for (Spider spider : spiders) {
            if (spider.getSpiderId().equals(spiderId)) {
                return spider;
            }
        }
        return null;
    }

    public SpiderId nextId() {
        return new SpiderId(UUID.randomUUID().toString());
    }

    public void remove(Spider spider) {
        spiders.remove(spider);
    }

    public void save(Spider spider) {
        spiders.add(spider);
    }
}

