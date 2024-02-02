package de.kessel.historyeventarchiv.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import de.kessel.historyeventarchiv.model.DescriptionDE;
import de.kessel.historyeventarchiv.model.HistoryEvent;
import de.kessel.historyeventarchiv.repository.DescriptionDeRepository;
import de.kessel.historyeventarchiv.repository.HistoryEventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import reactor.core.publisher.Flux;

import java.util.Arrays;

@Configuration
@EnableMongoRepositories
public class MongoConfiguration extends AbstractReactiveMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "testdb";
    }

    @Override
    @Bean
    public MongoClient reactiveMongoClient() {
        return MongoClients.create("mongodb://root:mongopw@localhost:27017");
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
    }

    @Bean
    @ConditionalOnProperty(prefix = "job.autorun", name = "enabled", havingValue = "true", matchIfMissing = true)
    public CommandLineRunner loadData(HistoryEventRepository historyEventRepository) {
        return (args) -> {
            var descriptionDE =  new DescriptionDE("WHO treffen");
            // save a couple of users
            var historyEventFlux = Flux.just(
                    new HistoryEvent("Rathaus Schöneberg", "Berlin", "Deutschland", 1, 2, 2020, Arrays.asList("Martin", "Kristian"), "event1", "de"),
                    new HistoryEvent("place 1", "London", "UK", 2, 3, 2021, Arrays.asList("Martin", "Kristian"), "event2", "en"),
                    new HistoryEvent("place 2", "Hamburg", "Deutschland", 3, 4, 2022, Arrays.asList("Martin", "Kristian"), "event3", "de"),
                    new HistoryEvent("place 3", "Leeds", "UK", 4, 5, 2023, Arrays.asList("Martin", "Kristian"), "event4", "en"),
                    new HistoryEvent("place 4", "Berlin", "Deutschland", 5, 6, 2023, Arrays.asList("Martin", "Kristian"), "event5", "de"),
                    new HistoryEvent("place 5", "Washington", "USA", 6, 7, 2023, Arrays.asList("Martin", "Kristian"), "event7", "en")
            );
            historyEventRepository.saveAll(historyEventFlux).subscribe();
        };
    }
}