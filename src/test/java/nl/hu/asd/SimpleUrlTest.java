package nl.hu.asd;

import nl.hu.asd.spider.SimpleUrl;
import org.junit.Test;

public class SimpleUrlTest
{
    @Test
    public void testConstructor() {
        SimpleUrl url = new SimpleUrl("//google.com");
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPath());
        System.out.println(url.isAbsoluteUrl());
        System.out.println(url.isAbsolutePath());
        System.out.println(url.toString());
    }
}
