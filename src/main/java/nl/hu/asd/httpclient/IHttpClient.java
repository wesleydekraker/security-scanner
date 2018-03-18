package nl.hu.asd.httpclient;

public interface IHttpClient {
    SimpleHttpRes connect(String url) throws HttpClientException;
}
