package nl.hu.asd.spider;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleUrlTest
{
    @Test
    public void testAbsoluteUrl() {
        SimpleUrl url = new SimpleUrl("http://google.com/");

        assertEquals(url.getProtocol(), "http");
        assertEquals(url.getHost(), "google.com");
        assertEquals(url.getPath(), "/");
        assertEquals(url.isAbsoluteUrl(), true);
        assertEquals(url.isAbsolutePath(), true);
        assertEquals(url.toString(), "http://google.com/");
    }

    @Test
    public void testRelativeProtocol() {
        SimpleUrl url = new SimpleUrl("//google.com");

        assertEquals(url.getProtocol(), null);
        assertEquals(url.getHost(), "google.com");
        assertEquals(url.getPath(), "/");
        assertEquals(url.isAbsoluteUrl(), true);
        assertEquals(url.isAbsolutePath(), true);
        assertEquals(url.toString(), "//google.com/");
    }

    @Test
    public void testAbsolutePath() {
        SimpleUrl url = new SimpleUrl("/index.html");

        assertEquals(url.getProtocol(), null);
        assertEquals(url.getHost(), null);
        assertEquals(url.getPath(), "/index.html");
        assertEquals(url.isAbsoluteUrl(), false);
        assertEquals(url.isAbsolutePath(), true);
        assertEquals(url.toString(), "/index.html");
    }

    @Test
    public void testRelativePath() {
        SimpleUrl url = new SimpleUrl("index.html");

        assertEquals(url.getProtocol(), null);
        assertEquals(url.getHost(), null);
        assertEquals(url.getPath(), "index.html");
        assertEquals(url.isAbsoluteUrl(), false);
        assertEquals(url.isAbsolutePath(), false);
        assertEquals(url.toString(), "index.html");
    }

    @Test
    public void testEquals() {
        SimpleUrl url1 = new SimpleUrl("http://google.com/");
        SimpleUrl url2 = new SimpleUrl("http://google.com/");

        assertEquals(url1, url2);
    }
}
