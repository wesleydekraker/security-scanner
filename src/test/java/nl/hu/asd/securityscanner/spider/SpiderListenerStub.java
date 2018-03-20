package nl.hu.asd.securityscanner.spider;

public class SpiderListenerStub implements ISpiderListener {
    private int totalVisitedUrls;

    public void newUrlVisited(SimpleUrl url) {
        totalVisitedUrls++;
    }

    public int getTotalVisitedUrls() {
        return totalVisitedUrls;
    }
}
