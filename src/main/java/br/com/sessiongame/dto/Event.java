package br.com.sessiongame.dto;

public class Event{
    private String url;
    private String visitorId;
    private long timestamp;
    public Event(){}
    public Event(String url, String visitorId, long timestamp) {
        this.url = url;
        this.visitorId = visitorId;
        this.timestamp = timestamp;
    }

    public String getUrl() {
        return url;
    }

    public String getVisitorId() {
        return visitorId;
    }

    public long getTimestamp() {
        return timestamp;
    }
}