package nl.hu.asd.spider;

public class QueuedUrl {
    private SimpleUrl url;
    private int depth;

    public QueuedUrl(SimpleUrl url, int depth) {
        this.url = url;
        this.depth = depth;
    }

    public SimpleUrl getUrl() {
        return url;
    }

    public int getDepth() {
        return depth;
    }
}
