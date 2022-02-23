package br.com.sessiongame.dto;

import java.util.List;
import java.util.Map;

public class SessionResponse {

    private Map<String, List<Session>> sessionsByUser;

    public SessionResponse(Map<String, List<Session>> sessionsByUser) {
        this.sessionsByUser = sessionsByUser;
    }

    public Map<String, List<Session>> getSessionsByUser() {
        return sessionsByUser;
    }

    public void setSessionsByUser(Map<String, List<Session>> sessionsByUser) {
        this.sessionsByUser = sessionsByUser;
    }

}
