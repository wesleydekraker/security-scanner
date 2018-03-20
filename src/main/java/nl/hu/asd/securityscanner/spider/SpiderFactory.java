package nl.hu.asd.securityscanner.spider;

import nl.hu.asd.securityscanner.httpclient.HttpClient;
import nl.hu.asd.securityscanner.httpclient.IHttpClient;
import nl.hu.asd.securityscanner.persistence.ISpiderRepository;
import nl.hu.asd.securityscanner.persistence.SpiderRepository;

public class SpiderFactory implements ISpiderFactory {
    public ISpiderRepository createSpiderRepository() {
        return new SpiderRepository();
    }

    public IHttpClient createHttpClient() {
        return new HttpClient();
    }
}
