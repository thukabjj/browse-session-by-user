package br.com.sessiongame.dto;

import java.util.List;

public class SessionByUser {

    private String visitorId;
    private List<String> pages;
    private Long duration;
    private Long startTime;

    public SessionByUser(){}

    public SessionByUser(String visitorId, List<String> pages, Long duration, Long startTime) {
        this.visitorId = visitorId;
        this.pages = pages;
        this.duration = duration;
        this.startTime = startTime;
    }

    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public List<String> getPages() {
        return pages;
    }

    public void setPages(List<String> pages) {
        this.pages = pages;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }
}
