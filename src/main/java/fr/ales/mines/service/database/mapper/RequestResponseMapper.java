package fr.ales.mines.service.database.mapper;

import fr.ales.mines.entities.Request11Response;
import fr.ales.mines.entities.Request12Response;
import fr.ales.mines.entities.Request20Response;
import fr.ales.mines.entities.Request2Response;
import fr.ales.mines.repository.dto.neo4j.Request11Neo4jResult;
import org.neo4j.driver.Record;

public interface RequestResponseMapper {

    static Request11Response map11(Request11Neo4jResult neo4jResult) {
        Request11Response.Request11ResponseBuilder builder = Request11Response.builder();

        return builder.productName(neo4jResult.getProductName())
            .totalQuantity(neo4jResult.getTotalQuantity())
            .numPurchases(neo4jResult.getNumPurchases())
            .build();
    }

    static Request11Response map11(Record neo4jResult) {
        Request11Response.Request11ResponseBuilder builder = Request11Response.builder();

        return builder.productName(String.valueOf(neo4jResult.get("product")))
            .totalQuantity(neo4jResult.get("total_quantity").asInt())
            .numPurchases(neo4jResult.get("num_purchases").asInt())
            .build();
    }

    static Request12Response map12(Record neo4jRecord) {
        Request12Response.Request12ResponseBuilder builder = Request12Response.builder();

        return builder.totalProduct(neo4jRecord.get("num_products").asInt())
            .totalQuantity(neo4jRecord.get("total_quantity").asInt())
            .numPurchases(neo4jRecord.get("num_purchases").asInt())
            .build();
    }

    static Request20Response map2(Record neo4jRecord) {
        Request20Response.Request20ResponseBuilder builder = Request20Response.builder();

        return builder.totalQuantity(neo4jRecord.get("total_quantity").asInt())
            .purchasesCount(neo4jRecord.get("num_purchases").asInt())
            .build();
    }

}
