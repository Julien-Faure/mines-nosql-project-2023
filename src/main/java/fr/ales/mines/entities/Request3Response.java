package fr.ales.mines.entities;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Request3Response {

    private List<Request30Response> payload;
    private long elapsedMsTime;
}
