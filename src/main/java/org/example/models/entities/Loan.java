package org.example.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Loan {

    private Integer id;
    private Book book;
    private User user;
    private LocalDate loanDate;
    private LocalDate returnDate;
}
