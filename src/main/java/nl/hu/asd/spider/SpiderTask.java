package nl.hu.asd.spider;

import nl.hu.asd.Entity;
import nl.hu.asd.httpclient.HttpClientException;
import nl.hu.asd.httpclient.IHttpClient;
import nl.hu.asd.httpclient.SimpleHttpRes;

import java.util.List;

public class SpiderTask extends Entity {
    private IHttpClient httpClient;

    private List<SimpleUrl> foundUrls;

    public SpiderTask(IHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public void startPageScan(SimpleUrl startUrl) {
        SimpleHttpRes response;
        try {
            response = httpClient.getResource(startUrl.toString());
        } catch (HttpClientException e) {
            e.printStackTrace();
            return;
        }

        this.foundUrls = SpiderHtmlParser.getUrls(startUrl, response.getBody());
    }

    public List<SimpleUrl> getFoundUrls() {
        return foundUrls;
    }
}
