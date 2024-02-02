package de.kessel.historyeventarchiv.service;

import de.kessel.historyeventarchiv.model.HistoryEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HistoryEventService {

    Flux<HistoryEvent> findAll();

    Flux<HistoryEvent> findByEventContaining(String event);

    Mono<HistoryEvent> findById(String id);

    Mono<HistoryEvent> save(HistoryEvent historyEvent);

    Mono<HistoryEvent> update(String id, HistoryEvent historyEvent);

    Mono<Void> deleteById(String id);

    Mono<Void> deleteAll();

    Flux<HistoryEvent> findByDay(int day);

    Flux<HistoryEvent> findByMonth(int month);

    Flux<HistoryEvent> findByYear(int year);

    Flux<HistoryEvent> findByPlace(String place);

    Flux<HistoryEvent> findByCity(String city);
}
