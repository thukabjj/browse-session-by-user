package br.com.sessiongame.dto;

import java.util.List;

public class EventRequest {

    private List<Event> events;

    public EventRequest(){}

    public EventRequest(List<Event> events) {
        this.events = events;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }


}
