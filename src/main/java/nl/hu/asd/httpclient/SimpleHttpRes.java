package nl.hu.asd.httpclient;

import nl.hu.asd.ValueObject;

public class SimpleHttpRes extends ValueObject {
    private int statusCode;
    private String body;

    public SimpleHttpRes(
            int statusCode,
            String body) {

        setStatusCode(statusCode);
        setBody(body);
    }

    public int getStatusCode() {
        return statusCode;
    }

    private void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getBody() {
        return body;
    }

    private void setBody(String body) {
        this.body = body;
    }
}
