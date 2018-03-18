package nl.hu.asd.httpclient;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class HttpClientStub implements IHttpClient {
    private String baseUrl = "http://example.com/";

    public SimpleHttpRes connect(String url) throws HttpClientException {
        if (!url.startsWith(baseUrl)) {
            throw new HttpClientException("Expected URL to start with: " + baseUrl + ", actual input: " + url);
        }

        if (url.endsWith("/")) {
            url = url + "index.html";
        }

        String filePath = url.substring(baseUrl.length());

        int statusCode = 200;

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(filePath);
        if (resource == null) {
            resource = classLoader.getResource("404.html");
            statusCode = 404;
        }

        File file = new File(resource.getFile());

        try {
            String responseBody = FileUtils.readFileToString(file, "UTF-8");
            return new SimpleHttpRes(statusCode, responseBody);
        } catch (IOException e) {
            throw new HttpClientException(e.getMessage());
        }
    }
}