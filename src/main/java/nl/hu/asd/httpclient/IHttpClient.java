package nl.hu.asd.httpclient;

public interface IHttpClient {
    public SimpleHttpRes connect(String url) throws HttpClientException;
}
