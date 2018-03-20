package nl.hu.asd;

import nl.hu.asd.httpclient.HttpClientStub;
import nl.hu.asd.httpclient.IHttpClient;
import nl.hu.asd.persistence.ISpiderRepository;
import nl.hu.asd.persistence.SpiderRepository;

public class FactoryStub implements IFactory {
    public ISpiderRepository createSpiderRepository() {
        return new SpiderRepository();
    }

    public IHttpClient createHttpClient() {
        return new HttpClientStub();
    }
}
