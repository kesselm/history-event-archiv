package de.kessel.historyeventarchiv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
public class HistoryEventArchivApplication {

    public static void main(String[] args) {
        SpringApplication.run(HistoryEventArchivApplication.class, args);
    }

}
