package fr.ales.mines.repository.dto.neo4j;

import org.springframework.data.neo4j.core.schema.Property;

public class Request11Neo4jResult {

    @Property("product")
    private String productName;

    @Property("total_quantity")
    private int totalQuantity;

    @Property("num_purchases")
    private int numPurchases;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getNumPurchases() {
        return numPurchases;
    }

    public void setNumPurchases(int numPurchases) {
        this.numPurchases = numPurchases;
    }

}
