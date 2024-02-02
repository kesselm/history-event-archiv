package de.kessel.historyeventarchiv.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class DescriptionDE {

    @Id
    private String id;

    private String text;

    public DescriptionDE(String text){
        this.text = text;
    }

}
