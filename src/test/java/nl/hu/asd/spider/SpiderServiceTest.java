package nl.hu.asd.spider;

import nl.hu.asd.FactoryStub;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SpiderServiceTest
{
    @Test
    public void testService() throws MalformedURLException {
        // overwrites factory for testing purposes
        SpiderService.setFactory(new FactoryStub());

        String id = SpiderService.generateId();

        SpiderService.startScan(
                id,
                "http://example.com/index.html",
                -1,
                -1
        );

        Set<SimpleUrl> urls = SpiderService.getVisitedUrls(id);

        Set<SimpleUrl> expectedUrls = new HashSet<>(Arrays.asList(
                new SimpleUrl("http://example.com/index.html"),
                new SimpleUrl("http://example.com/london/index.html"),
                new SimpleUrl("http://example.com/paris/index.html"),
                new SimpleUrl("http://example.com/tokyo/index.html"),
                new SimpleUrl("http://example.com/"),
                new SimpleUrl("http://example.com/london/buildings.html"),
                new SimpleUrl("http://example.com/paris/food.html"),
                new SimpleUrl("http://example.com/tokyo/map.html"),
                new SimpleUrl("http://example.com/london/the-welding-institute.html"),
                new SimpleUrl("http://example.com/license.html")
        ));

        assertEquals(expectedUrls, urls);
    }
}
