package nl.hu.asd.spider;

import org.junit.Test;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;

public class UrlResolverTest
{
    @Test
    public void testGetAbsoluteUrl() throws MalformedURLException {
        assertGetAbsoluteUrl(
                "http://example.com/",
                "index.html",
                "http://example.com/index.html"
        );

        assertGetAbsoluteUrl(
                "http://example.com/tokyo/map.html",
                "index.html",
                "http://example.com/tokyo/index.html"
        );

        assertGetAbsoluteUrl(
                "http://example.com/tokyo/index.html",
                "/index.html",
                "http://example.com/index.html"
        );

        assertGetAbsoluteUrl(
                "http://example.com/tokyo/index.html",
                "//example.com/index.html",
                "http://example.com/index.html"
        );

        assertGetAbsoluteUrl(
                "http://example.com/tokyo/index.html",
                "http://example.com/index.html",
                "http://example.com/index.html"
        );
    }

    public void assertGetAbsoluteUrl(String current, String target, String expected) throws MalformedURLException {
        SimpleUrl result = UrlResolver.getAbsoluteUrl(new SimpleUrl(current), new SimpleUrl(target));
        assertEquals(new SimpleUrl(expected), result);
    }
}
