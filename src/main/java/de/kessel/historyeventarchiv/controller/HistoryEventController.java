package de.kessel.historyeventarchiv.controller;

import de.kessel.historyeventarchiv.model.HistoryEvent;
import de.kessel.historyeventarchiv.service.HistoryEventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class HistoryEventController {

    @Autowired
    HistoryEventServiceImpl historyEventServiceImpl;

    @GetMapping("/events")
    @ResponseStatus(HttpStatus.OK)
    public Flux<HistoryEvent> getAllHistoryEvent(@RequestParam(required = false) String title) {
        if (title == null)
            return historyEventServiceImpl.findAll();
        else
            return historyEventServiceImpl.findByEventContaining(title);
    }

    @GetMapping("/events/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<HistoryEvent> getHistoryEventById(@PathVariable("id") String id) {
        return historyEventServiceImpl.findById(id);
    }

    @PostMapping("/events")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<HistoryEvent> createHistoryEvent(@RequestBody HistoryEvent historyEvent) {
        return historyEventServiceImpl.save(historyEvent);
    }

    @PutMapping("/events/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<HistoryEvent> updateHistoryEvent(@PathVariable("id") String id, @RequestBody HistoryEvent historyEvent) {
        return historyEventServiceImpl.update(id, historyEvent);
    }

    @DeleteMapping("/events/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteTutorial(@PathVariable("id") String id) {
        return historyEventServiceImpl.deleteById(id);
    }

    @DeleteMapping("/events")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAllTutorials() {
        return historyEventServiceImpl.deleteAll();
    }

//    @GetMapping("/events")
//    @ResponseStatus(HttpStatus.OK)
//    public Flux<HistoryEvent> findByYear(@RequestParam("year") int year) {
//        return historyEventServiceImpl.findByYear(year);
//    }
}