package de.kessel.historyeventarchiv.repository;

import de.kessel.historyeventarchiv.model.HistoryEvent;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface HistoryEventRepository extends ReactiveMongoRepository<HistoryEvent, String> {

    Flux<HistoryEvent> findByEventContaining(String title);

    Flux<HistoryEvent> findByDay(int day);

    Flux<HistoryEvent> findByMonth(int month);

    Flux<HistoryEvent> findByYear(int year);

    Flux<HistoryEvent> findByPlace(String place);

    Flux<HistoryEvent> findByCity(String city);
}