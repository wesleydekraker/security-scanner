package nl.hu.asd.spider;

import nl.hu.asd.httpclient.HttpClientException;
import nl.hu.asd.httpclient.HttpClientStub;
import nl.hu.asd.httpclient.SimpleHttpRes;

import java.util.List;

public class SpiderTask {
    private List<SimpleUrl> foundUrls;

    public void start(SimpleUrl startUrl) {
        HttpClientStub httpClientStub = new HttpClientStub();
        SimpleHttpRes response;
        try {
            response = httpClientStub.connect(startUrl.toString());
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
