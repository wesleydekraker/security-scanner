package nl.hu.asd;

import nl.hu.asd.httpclient.HttpClient;
import nl.hu.asd.httpclient.IHttpClient;
import nl.hu.asd.persistence.ISpiderRepository;
import nl.hu.asd.persistence.SpiderRepository;

public class Factory implements IFactory {
    public ISpiderRepository createSpiderRepository() {
        return new SpiderRepository();
    }

    public IHttpClient createHttpClient() {
        return new HttpClient();
    }
}
