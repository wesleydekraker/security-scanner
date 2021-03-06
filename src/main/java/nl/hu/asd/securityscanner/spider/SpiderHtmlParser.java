package nl.hu.asd.securityscanner.spider;

import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;
import nl.hu.asd.securityscanner.Service;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class SpiderHtmlParser extends Service {
    private SpiderHtmlParser() { }

    public static List<SimpleUrl> getUrls(SimpleUrl currentUrl, String messageBody) {
        List<SimpleUrl> urls = new ArrayList<>();

        Source source = new Source(messageBody);

        List<Element> elements = source.getAllElements(HTMLElementName.A);
        for (Element element : elements) {
            String attributeValue = element.getAttributeValue("href");

            if (attributeValue == null) {
                continue;
            }

            SimpleUrl targetUrl = new SimpleUrl(attributeValue);
            SimpleUrl absoluteUrl;
            try {
                absoluteUrl = UrlResolver.getAbsoluteUrl(currentUrl, targetUrl);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                continue;
            }

            urls.add(absoluteUrl);
        }

        return urls;
    }
}
