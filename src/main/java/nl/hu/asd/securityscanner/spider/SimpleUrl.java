package nl.hu.asd.securityscanner.spider;

import nl.hu.asd.securityscanner.ValueObject;

import java.net.MalformedURLException;
import java.util.Objects;

public class SimpleUrl extends ValueObject {
    public static final String PROTOCOL_PATTERN = "://";
    public static final String RELATIVE_PROTOCOL_PATTERN = "//";

    private String protocol;
    private String host;
    private String path;

    private boolean absoluteUrl;
    private boolean absolutePath;

    public SimpleUrl(String url) {
        String strippedUrl = url;

        if (hasRelativeProtocol(strippedUrl)) {
            setRelativeProtocol();
            strippedUrl = stripRelativeProtocol(strippedUrl);
        } else if (hasProtocol(strippedUrl)) {
            setProtocol(strippedUrl);
            strippedUrl = stripProtocol(strippedUrl);
        }

        if (isAbsoluteUrl()) {
            setHost(strippedUrl);
            strippedUrl = stripHost(strippedUrl);
        }

        if (isAbsoluteUrl() && strippedUrl.isEmpty()) {
            strippedUrl = "/";
        }

        setPath(strippedUrl);
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

    private boolean hasRelativeProtocol(String url) {
        return url.startsWith(RELATIVE_PROTOCOL_PATTERN);
    }

    private String stripRelativeProtocol(String url) {
        return url.substring(RELATIVE_PROTOCOL_PATTERN.length());
    }

    private void setRelativeProtocol() {
        this.absoluteUrl = true;
    }

    private boolean hasProtocol(String url) {
        return url.contains(PROTOCOL_PATTERN);
    }

    private void setProtocol(String url) {
        int protocolIndex = url.indexOf(PROTOCOL_PATTERN);
        this.protocol = url.substring(0, protocolIndex);
        this.absoluteUrl = true;
    }

    private String stripProtocol(String url) {
        int protocolIndex = url.indexOf(PROTOCOL_PATTERN);
        return url.substring(protocolIndex + PROTOCOL_PATTERN.length());
    }

    private void setHost(String strippedUrl) {
        int pathIndex = strippedUrl.indexOf("/");
        if (pathIndex == -1) {
            this.host = strippedUrl;
            return;
        }

        this.host = strippedUrl.substring(0, pathIndex);
    }

    private String stripHost(String urlWithoutProtocol) {
        int pathIndex = urlWithoutProtocol.indexOf("/");
        if (pathIndex == -1) {
            return "";
        }

        return urlWithoutProtocol.substring(pathIndex);
    }

    private void setPath(String path) {
        this.absolutePath = path.startsWith("/");
        this.path = path;
    }

    public String getBasePath() {
        int i = path.lastIndexOf('/');
        return path.substring(0, i + 1);
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

    @Override
    public String toString() {
        if (isAbsoluteUrl() && protocol != null) {
            return getProtocol() + PROTOCOL_PATTERN + getHost() + getPath();
        }

        if (isAbsoluteUrl() && protocol == null) {
            return RELATIVE_PROTOCOL_PATTERN + getHost() + getPath();
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
