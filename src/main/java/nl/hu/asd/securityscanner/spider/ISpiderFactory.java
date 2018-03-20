package nl.hu.asd.securityscanner.spider;

import nl.hu.asd.securityscanner.httpclient.IHttpClient;
import nl.hu.asd.securityscanner.persistence.ISpiderRepository;

public interface ISpiderFactory {
    ISpiderRepository createSpiderRepository();

    IHttpClient createHttpClient();
}
