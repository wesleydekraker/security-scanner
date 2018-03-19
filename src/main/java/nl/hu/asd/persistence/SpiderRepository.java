package nl.hu.asd.persistence;

import nl.hu.asd.spider.Spider;
import nl.hu.asd.spider.SpiderId;

import java.util.HashSet;
import java.util.Set;

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

    public void remove(Spider spider) {
        spiders.remove(spider);
    }

    public void save(Spider spider) {
        spiders.add(spider);
    }
}

