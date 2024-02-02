package de.kessel.historyeventarchiv.repository;

import de.kessel.historyeventarchiv.model.DescriptionDE;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionDeRepository extends ReactiveMongoRepository<DescriptionDE, String> {
}
