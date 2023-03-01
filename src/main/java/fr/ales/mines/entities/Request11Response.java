package fr.ales.mines.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Request11Response {
    private String productName;
    private int totalQuantity;
    private int numPurchases;
}
