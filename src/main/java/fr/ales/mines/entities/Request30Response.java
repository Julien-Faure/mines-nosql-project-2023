package fr.ales.mines.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Request30Response {

    private String productName;
    private int usersCount;
}
