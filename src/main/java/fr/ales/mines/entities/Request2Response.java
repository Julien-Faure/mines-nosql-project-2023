package fr.ales.mines.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Request2Response {
    private Request20Response payload;
    private long elapsedMsTime;
}
