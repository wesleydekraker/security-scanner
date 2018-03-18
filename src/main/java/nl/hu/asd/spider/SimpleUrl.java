package nl.hu.asd.spider;

import java.net.MalformedURLException;
import java.util.Objects;

public class SimpleUrl {
    private String protocol;
    private String host;
    private String path;

    private boolean absoluteUrl;
    private boolean absolutePath;

    public SimpleUrl(String url) {
        this.absoluteUrl = isAbsoluteUrl(url);

        if (this.absoluteUrl) {
            url = stripProtocol(url);
            url = stripHost(url);
        }

        String path = url;

        this.absolutePath = isAbsolutePath(path);

        if (isAbsolutePath()) {
            path = stripLeadingSlash(path);
        }

        this.path = path;
    }

    public SimpleUrl(String protocol, String host, String path) throws MalformedURLException {
        if (protocol == null || host == null || path == null) {
            throw new MalformedURLException();
        }

        this.absoluteUrl = true;
        this.absolutePath = true;

        this.protocol = protocol;
        this.host = host;
        this.path = path;
    }

    private boolean isAbsoluteUrl(String url) {
        return url.startsWith("//") || url.contains("://");
    }

    private boolean isAbsolutePath(String path) {
        return path.startsWith("/");
    }

    private String stripProtocol(String url) {
        if (url.startsWith("//")) {
            url = url.substring(2);
            return url;
        }

        int protocolIndex = url.indexOf("://");
        if (protocolIndex != -1) {
            this.protocol = url.substring(0, protocolIndex);

            url = url.substring(protocolIndex + 3);
            return url;
        }

        return url;
    }

    private String stripHost(String url) {
        int pathIndex = url.indexOf("/");
        if (pathIndex == -1) {
            this.host = url;
            return "";
        }

        this.host = url.substring(0, pathIndex);
        return url.substring(pathIndex);
    }

    private String stripLeadingSlash(String path) {
        return path.substring(1);
    }

    public String getProtocol() {
        return protocol;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    public boolean isAbsoluteUrl() {
        return absoluteUrl;
    }

    public boolean isAbsolutePath() {
        return absolutePath;
    }

    public String getBasePath() {
        int i = path.lastIndexOf('/');
        return path.substring(0, i + 1);
    }

    @Override
    public String toString() {
        if (isAbsoluteUrl() && protocol != null) {
            return getProtocol() + "://" + getHost() + "/" + getPath();
        }

        if (isAbsoluteUrl() && protocol == null) {
            return "//" + getHost() + "/" + getPath();
        }

        if (isAbsolutePath()) {
            return "/" + getPath();
        }

        return getPath();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleUrl simpleUrl = (SimpleUrl) o;
        return absoluteUrl == simpleUrl.absoluteUrl &&
                absolutePath == simpleUrl.absolutePath &&
                Objects.equals(protocol, simpleUrl.protocol) &&
                Objects.equals(host, simpleUrl.host) &&
                Objects.equals(path, simpleUrl.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(protocol, host, path, absoluteUrl, absolutePath);
    }
}
