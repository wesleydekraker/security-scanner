package nl.hu.asd.spider;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleUrlTest
{
    @Test
    public void testEquals() {
        SimpleUrl url1 = new SimpleUrl("http://google.com");
        SimpleUrl url2 = new SimpleUrl("http://google.com/");

        assertEquals(url1, url2);
    }
}
