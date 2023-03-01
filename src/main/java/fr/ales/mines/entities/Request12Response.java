package fr.ales.mines.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Request12Response {
    private int totalProduct;
    private int totalQuantity;
    private int numPurchases;
}
