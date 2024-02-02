package de.kessel.historyeventarchiv.service;

import de.kessel.historyeventarchiv.model.HistoryEvent;
import de.kessel.historyeventarchiv.repository.HistoryEventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@AllArgsConstructor
public class HistoryEventServiceImpl implements HistoryEventService {

    HistoryEventRepository historyEventRepository;

    public Flux<HistoryEvent> findAll() {
        return historyEventRepository.findAll();
    }

    public Flux<HistoryEvent> findByEventContaining(String event) {
        return historyEventRepository.findByEventContaining(event);
    }

    public Mono<HistoryEvent> findById(String id) {
        return historyEventRepository.findById(id);
    }

    public Mono<HistoryEvent> save(HistoryEvent historyEvent) {
        return historyEventRepository.save(historyEvent);
    }

    public Mono<HistoryEvent> update(String id, HistoryEvent historyEvent) {
        return historyEventRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalTutorial -> {
                    if (optionalTutorial.isPresent()) {
                        historyEvent.setId(id);
                        return historyEventRepository.save(historyEvent);
                    }

                    return Mono.empty();
                });
    }

    public Mono<Void> deleteById(String id) {
        return historyEventRepository.deleteById(id);
    }

    public Mono<Void> deleteAll() {
        return historyEventRepository.deleteAll();
    }

    public Flux<HistoryEvent> findByDay(int day) {
        return historyEventRepository.findByDay(day);
    }

    public Flux<HistoryEvent> findByMonth(int month){
        return historyEventRepository.findByMonth(month);
    }

    public Flux<HistoryEvent> findByYear(int year){
        return historyEventRepository.findByYear(year);
    }

    public Flux<HistoryEvent> findByPlace(String place){
        return historyEventRepository.findByPlace(place);
    }

    public Flux<HistoryEvent> findByCity(String city){
        return historyEventRepository.findByCity(city);
    }

}