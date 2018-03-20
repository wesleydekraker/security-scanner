package nl.hu.asd.securityscanner.spider;

import nl.hu.asd.securityscanner.Service;

import java.net.MalformedURLException;

public class UrlResolver extends Service {
    private UrlResolver() { }

    public static SimpleUrl getAbsoluteUrl(SimpleUrl currentUrl, SimpleUrl targetUrl) throws MalformedURLException {
        String path = null;

        if (targetUrl.isAbsolutePath()) {
            path = targetUrl.getPath();
        }

        if (!targetUrl.isAbsolutePath()) {
            path = currentUrl.getBasePath() + targetUrl.getPath();
        }

        if (targetUrl.isAbsoluteUrl() && targetUrl.getProtocol() == null) {
            return new SimpleUrl(currentUrl.getProtocol(), targetUrl.getHost(), path);
        }

        if (!targetUrl.isAbsoluteUrl()) {
            return new SimpleUrl(currentUrl.getProtocol(), currentUrl.getHost(), path);
        }

        return new SimpleUrl(currentUrl.getProtocol(), targetUrl.getHost(), path);
    }
}
