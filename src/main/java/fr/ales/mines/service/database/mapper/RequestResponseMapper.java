package fr.ales.mines.service.database.mapper;

import fr.ales.mines.entities.*;
import org.neo4j.driver.Record;

public interface RequestResponseMapper {
    static Request11Response map11(Record neo4jResult) {
        Request11Response.Request11ResponseBuilder builder = Request11Response.builder();

        return builder
            .productName(String.valueOf(neo4jResult.get("product")))
            .totalQuantity(neo4jResult.get("total_quantity").asInt())
            .numPurchases(neo4jResult.get("num_purchases").asInt())
            .build();
    }


    static Request11Response mapPostgres11(String[] line) {
        Request11Response.Request11ResponseBuilder builder = Request11Response.builder();

        return builder
            .productName(line[0])
            .totalQuantity(Integer.parseInt(line[1]))
            .numPurchases(Integer.parseInt(line[2]))
            .build();
    }

    static Request12Response map12(Record neo4jRecord) {
        Request12Response.Request12ResponseBuilder builder = Request12Response.builder();

        return builder
            .totalProduct(neo4jRecord.get("num_products").asInt())
            .totalQuantity(neo4jRecord.get("total_quantity").asInt())
            .numPurchases(neo4jRecord.get("num_purchases").asInt())
            .build();
    }

    static Request12Response mapPostgres12(String[][] request12) {
        Request12Response.Request12ResponseBuilder builder = Request12Response.builder();
        String[] line = request12[0];

        return builder
            .totalProduct(Integer.parseInt(line[0]))
            .totalQuantity(Integer.parseInt(line[1]))
            .numPurchases(Integer.parseInt(line[2]))
            .build();
    }

    static Request20Response map2(Record neo4jRecord) {
        Request20Response.Request20ResponseBuilder builder = Request20Response.builder();

        return builder
            .totalQuantity(neo4jRecord.get("total_quantity").asInt())
            .purchasesCount(neo4jRecord.get("num_purchases").asInt())
            .build();
    }

    static Request20Response mapPostgres2(String[][] request2) {
        Request20Response.Request20ResponseBuilder builder = Request20Response.builder();

        String[] line = request2[0];
        if(line[0] == null)
            line[0] = "0";
        return builder
            .totalQuantity(Integer.parseInt(line[0]))
            .purchasesCount(Integer.parseInt(line[1]))
            .build();
    }


    static Request30Response mapPostgres3(String[] request3) {
        Request30Response.Request30ResponseBuilder builder = Request30Response.builder();

        return builder
            .level(Integer.parseInt(request3[0]))
            .usersCount(Integer.parseInt(request3[1]))
            .build();
    }
}
