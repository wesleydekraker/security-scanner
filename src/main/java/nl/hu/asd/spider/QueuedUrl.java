package nl.hu.asd.spider;

import nl.hu.asd.ValueObject;

public class QueuedUrl extends ValueObject {
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
