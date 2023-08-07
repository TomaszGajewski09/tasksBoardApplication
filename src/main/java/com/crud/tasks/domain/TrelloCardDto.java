package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

//@Data
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class TrelloCardDto {


    private String name;
    private String description;
    private String pos;
    private String listId;
}
