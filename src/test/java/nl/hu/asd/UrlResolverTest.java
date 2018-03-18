package nl.hu.asd;

import nl.hu.asd.spider.SimpleUrl;
import nl.hu.asd.spider.UrlResolver;
import org.junit.Test;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;

public class UrlResolverTest
{
    @Test
    public void testGetAbsoluteUrl() throws MalformedURLException {
        SimpleUrl result = UrlResolver.getAbsoluteUrl(new SimpleUrl("http://example.com/"), new SimpleUrl("index.html"));
        assertEquals("http://example.com/index.html", result.toString());

        result = UrlResolver.getAbsoluteUrl(new SimpleUrl("http://example.com/tokyo/map.html"), new SimpleUrl("index.html"));
        assertEquals("http://example.com/tokyo/index.html", result.toString());

        result = UrlResolver.getAbsoluteUrl(new SimpleUrl("http://example.com/tokyo/index.html"), new SimpleUrl("/index.html"));
        assertEquals("http://example.com/index.html", result.toString());

        result = UrlResolver.getAbsoluteUrl(new SimpleUrl("http://example.com/tokyo/index.html"), new SimpleUrl("//example.com/index.html"));
        assertEquals("http://example.com/index.html", result.toString());

        result = UrlResolver.getAbsoluteUrl(new SimpleUrl("http://example.com/tokyo/index.html"), new SimpleUrl("http://example.com/index.html"));
        assertEquals("http://example.com/index.html", result.toString());
    }
}
