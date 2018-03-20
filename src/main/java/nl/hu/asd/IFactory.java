package nl.hu.asd;

import nl.hu.asd.httpclient.IHttpClient;
import nl.hu.asd.persistence.ISpiderRepository;

public interface IFactory {
    ISpiderRepository createSpiderRepository();

    IHttpClient createHttpClient();
}
