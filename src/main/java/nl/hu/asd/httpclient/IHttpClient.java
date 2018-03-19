package nl.hu.asd.httpclient;

public interface IHttpClient {
    SimpleHttpRes getResource(String url) throws HttpClientException;
}
