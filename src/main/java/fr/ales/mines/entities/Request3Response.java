package fr.ales.mines.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Request3Response {

    private Request30Response payload;
    private long elapsedMsTime;
}
