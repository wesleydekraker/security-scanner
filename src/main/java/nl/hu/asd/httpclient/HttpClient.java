package nl.hu.asd.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClient implements IHttpClient {
    public SimpleHttpRes connect(String url) throws HttpClientException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response;

        try {
            response = httpclient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();

            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity);

            EntityUtils.consume(entity);
            response.close();

            return new SimpleHttpRes(statusCode, responseBody);
        } catch (IOException e) {
            throw new HttpClientException(e.getMessage());
        }
    }
}
