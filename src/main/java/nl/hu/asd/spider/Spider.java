package nl.hu.asd.spider;

import nl.hu.asd.Entity;
import nl.hu.asd.httpclient.IHttpClient;

import java.net.MalformedURLException;
import java.util.*;

public class Spider extends Entity {
    private IHttpClient httpClient;

    private Queue<QueuedUrl> queue;
    private Set<SimpleUrl> visited;

    private int maxChildren;
    private int maxDepth;

    public Spider() {
        queue = new LinkedList<>();
        visited = new LinkedHashSet<>();

        maxChildren = -1;
        maxDepth = -1;
    }

    public void addSeed(String url) throws MalformedURLException {
        SimpleUrl simpleUrl = new SimpleUrl(url);
        if (!simpleUrl.isAbsoluteUrl() || simpleUrl.getProtocol() == null) {
            throw new MalformedURLException();
        }

        if (isNewUrl(simpleUrl)) {
            addToQueue(simpleUrl, 0);
        }
    }

    public void start() {
        while (!queue.isEmpty()) {
            QueuedUrl current = queue.poll();
            if (maxDepth != -1 && current.getDepth() >= maxDepth) {
                break;
            }

            SpiderTask spiderTask = new SpiderTask(httpClient);
            spiderTask.start(current.getUrl());
            visited.add(current.getUrl());

            addNewUrlsToQueue(spiderTask.getFoundUrls(), current.getDepth() + 1);
        }
    }

    private void addNewUrlsToQueue(List<SimpleUrl> urls, int depth) {
        int total = 0;

        for (SimpleUrl url : urls) {
            if (maxChildren != -1 && total >= maxChildren) {
                break;
            }

            if (isNewUrl(url)) {
                addToQueue(url, depth);
                total++;
            }
        }
    }

    private void addToQueue(SimpleUrl url, int depth) {
        QueuedUrl newUrl = new QueuedUrl(url, depth);
        queue.add(newUrl);
    }

    private boolean isNewUrl(SimpleUrl url) {
        if (visited.contains(url)) {
            return false;
        }

        for (QueuedUrl queuedUrl : this.queue) {
            if (queuedUrl.getUrl().equals(url)) {
                return false;
            }
        }

        return true;
    }

    public Set<SimpleUrl> getVisitedUrls() {
        return visited;
    }

    public void setHttpClient(IHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public void setMaxChildren(int maxChildren) {
        this.maxChildren = maxChildren;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }
}
