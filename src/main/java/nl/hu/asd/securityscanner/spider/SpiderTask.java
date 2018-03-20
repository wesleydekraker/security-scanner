package nl.hu.asd.securityscanner.spider;

import nl.hu.asd.securityscanner.Entity;
import nl.hu.asd.securityscanner.httpclient.HttpClientException;
import nl.hu.asd.securityscanner.httpclient.IHttpClient;
import nl.hu.asd.securityscanner.httpclient.SimpleHttpRes;

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
