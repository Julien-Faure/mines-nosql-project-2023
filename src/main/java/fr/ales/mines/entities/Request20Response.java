package fr.ales.mines.entities;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Request20Response {
    private int totalQuantity;
    private int purchasesCount;
}
