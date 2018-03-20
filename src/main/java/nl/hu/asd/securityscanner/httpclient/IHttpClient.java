package nl.hu.asd.securityscanner.httpclient;

public interface IHttpClient {
    SimpleHttpRes getResource(String url) throws HttpClientException;
}
