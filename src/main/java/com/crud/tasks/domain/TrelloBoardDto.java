package com.crud.tasks.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
// Zamiast tego @Data
@Data
public class TrelloBoardDto {
    private String name;
    public String id;
}
