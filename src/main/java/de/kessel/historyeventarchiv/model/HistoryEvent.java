package de.kessel.historyeventarchiv.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter
@Setter
public class HistoryEvent {

    @Id
    private String id;

    private String place;

    private String city;

    private String country;

    private int day;

    private int month;

    private int year;

    private List<String> persons;

    private String event;

    private String language;

    public HistoryEvent(String place, String city, String country,
                        int day, int month, int year, List<String> persons,
                        String event, String language){
        this.place = place;
        this.city = city;
        this.country = country;
        this.day = day;
        this.month = month;
        this.year = year;
        this.persons = persons;
        this.event = event;
        this.language = language;
    }

}
