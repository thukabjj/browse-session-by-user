package br.com.sessiongame.service;

import br.com.sessiongame.dto.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SessionGameService {
    private final long TEN_MINUTES = (10 * 60 * 1000);

    public SessionResponse getSessionByUser(EventRequest request) {

        /**
         * Deve-se mapear todos os events by visitorID
         * Deve-se mapear e agrupar todas as rotas no qual o usuario acessou dentro do range de 10 minutos comparando os seus timestamp
         *  exemplo
         *
         *  {
         *       "duration" : 1425761,
         *       "pages" : [ "/whirl-doubtful-flesh/cheer-aboard-thread", "/alert-faint-daughter", "/knit-loose-caption/smash-changeable-measure", "/shine-towering-flag", "/shine-towering-flag", "/pioneer-clammy-fire/photograph-wide-eyed-quince", "/skip-mature-goat", "/operate-aboriginal-story" ],
         *       "startTime" : 1515102395118
         *   }
         *
         *
         * */

        final Map<String, List<Event>> eventsByVisitorID = request.getEvents().stream()
                .collect(Collectors.groupingBy(Event::getVisitorId))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().stream().sorted(Comparator.comparingLong(Event::getTimestamp))
                        .collect(Collectors.toList())));

        final Map<String, List<Session>> collect = new HashMap<>();

                eventsByVisitorID.entrySet().stream().map(entrySet -> {

                    final String visitorID = entrySet.getKey();
                    final List<Event> events = entrySet.getValue();
                    var firstTimestamp = events.get(0).getTimestamp();
                    var lastTimestamp = events.get(events.size() - 1).getTimestamp();

                    var ranges = getRangeByEvents(firstTimestamp, lastTimestamp);

                    final List<SessionByUser> result = getSessionByUsers(visitorID, events, ranges);

                    return result;
                })
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(SessionByUser::getVisitorId))
                .forEach((k,v) ->{
                   collect.put(k,v.stream().map( d -> new Session(d.getPages(),d.getDuration(),d.getStartTime())).collect(Collectors.toList())) ;
                });

        return new SessionResponse(collect);

    }

    private List<SessionByUser> getSessionByUsers(String visitorID, List<Event> events, List<Long> ranges) {
        List<SessionByUser> res = new ArrayList<>();
        for (int i = 0; i < ranges.size(); i++) {
            final Long range = ranges.get(i);

            List<Event> eventsByRange = new ArrayList<>();

            if (range != ranges.get(ranges.size() - 1)) {
                final Long proximoRange = ranges.get(i + 1);
                eventsByRange = events.stream().collect(Collectors.groupingBy(it -> (it.getTimestamp() >= range && it.getTimestamp() <= proximoRange))).get(true);
            } else {
                eventsByRange = events.stream().collect(Collectors.groupingBy(it -> it.getTimestamp() >= range)).get(true);
            }
            if (eventsByRange != null && !eventsByRange.isEmpty()) {
                final long startTime = eventsByRange.get(0).getTimestamp();
                final SessionByUser sessionByUser = new SessionByUser(visitorID,
                        eventsByRange.stream().map(Event::getUrl).collect(Collectors.toList()),
                        eventsByRange.get(eventsByRange.size() - 1).getTimestamp() - startTime,
                        startTime);
                res.add(sessionByUser);
            }
        }
        return res;

    }

    private List<Long> getRangeByEvents(long firstTimestamp, long lastTimestamp) {
        List<Long> response = new ArrayList<>();
        for (long i = firstTimestamp; i < lastTimestamp; i += TEN_MINUTES) {
            response.add(i);
        }
        return response;
    }

}
