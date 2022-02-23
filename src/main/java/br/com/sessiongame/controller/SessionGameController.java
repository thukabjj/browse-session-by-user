package br.com.sessiongame.controller;

import br.com.sessiongame.dto.EventRequest;
import br.com.sessiongame.service.SessionGameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionGameController {
    private final SessionGameService service;

    public SessionGameController(SessionGameService service) {
        this.service = service;
    }

    @PostMapping("session")
    public ResponseEntity<?> getSessionByUser(@RequestBody EventRequest request){
        return ResponseEntity.ok(service.getSessionByUser(request));
    }
}
