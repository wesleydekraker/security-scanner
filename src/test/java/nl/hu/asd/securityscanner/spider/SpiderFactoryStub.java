package nl.hu.asd.securityscanner.spider;

import nl.hu.asd.securityscanner.httpclient.HttpClientStub;
import nl.hu.asd.securityscanner.httpclient.IHttpClient;
import nl.hu.asd.securityscanner.persistence.ISpiderRepository;
import nl.hu.asd.securityscanner.persistence.SpiderRepository;

public class SpiderFactoryStub implements ISpiderFactory {
    public ISpiderRepository createSpiderRepository() {
        return new SpiderRepository();
    }

    public IHttpClient createHttpClient() {
        return new HttpClientStub();
    }
}
