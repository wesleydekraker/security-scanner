package nl.hu.asd.securityscanner.persistence;

import nl.hu.asd.securityscanner.spider.Spider;
import nl.hu.asd.securityscanner.spider.SpiderId;

public interface ISpiderRepository {
    Spider get(SpiderId spiderId);

    SpiderId nextId();

    void remove(Spider spider);

    void save(Spider spider);
}

