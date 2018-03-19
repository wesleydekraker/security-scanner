package nl.hu.asd.persistence;

import nl.hu.asd.spider.Spider;
import nl.hu.asd.spider.SpiderId;

public interface ISpiderRepository {
    Spider get(SpiderId spiderId);

    void remove(Spider spider);

    void save(Spider spider);
}

