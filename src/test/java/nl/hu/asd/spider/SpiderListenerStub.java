package nl.hu.asd.spider;

public class SpiderListenerStub implements ISpiderListener {
    private int totalVisitedUrls;

    public void newUrlVisited(SimpleUrl url) {
        totalVisitedUrls++;
    }

    public int getTotalVisitedUrls() {
        return totalVisitedUrls;
    }
}
