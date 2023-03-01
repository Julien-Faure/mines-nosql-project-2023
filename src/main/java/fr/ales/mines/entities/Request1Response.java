package fr.ales.mines.entities;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Request1Response {
    private final List<Request11Response> request11Response;
    private final Request12Response request12Response;
    private long elapsedMsTime;

}
