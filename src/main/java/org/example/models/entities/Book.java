package org.example.models.entities;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Book {

    private Integer id;
    private String title;
    private String author;
    private Integer publisher;
    private Integer availableUnits;
}
