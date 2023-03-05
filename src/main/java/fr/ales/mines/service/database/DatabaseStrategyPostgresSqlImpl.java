package fr.ales.mines.service.database;

import fr.ales.mines.entities.*;
import fr.ales.mines.repository.dto.postgres.PersonPostgresRepository;
import fr.ales.mines.service.database.mapper.PersonMapper;
import fr.ales.mines.service.database.mapper.RequestResponseMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class DatabaseStrategyPostgresSqlImpl implements DatabaseStrategy {

    private final PersonPostgresRepository repository;

    @Autowired
    public DatabaseStrategyPostgresSqlImpl(PersonPostgresRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Person> listPerson() {
        return repository.findAll(Pageable.ofSize(10)).stream().map(PersonMapper::map).toList();
    }

    @Override
    public Request1Response executeRequest1(String username, int depth) {
        long start = System.currentTimeMillis();
        String[][] request11 = this.repository.executeRequest11(username, depth);
        String[][] request12 = this.repository.executeRequest12(username, depth);
        ArrayList<Request11Response> request11Responses = new ArrayList<>();
        for (String[] line : request11) {
            request11Responses.add(RequestResponseMapper.mapPostgres11(line));
        }

        Request12Response request12Response = RequestResponseMapper.mapPostgres12(request12);

        return Request1Response
            .builder()
            .elapsedMsTime(System.currentTimeMillis() - start)
            .request11Response(request11Responses)
            .request12Response(request12Response)
            .build();
    }

    @Override
    public Request2Response executeRequest2(String username, int depth, String productName) {
        long start = System.currentTimeMillis();

        String[][] request2 = this.repository.executeRequest2(username, depth, productName);

        Request20Response response = RequestResponseMapper.mapPostgres2(request2);

        return Request2Response.builder().elapsedMsTime(System.currentTimeMillis() - start).payload(response).build();
    }

    @Override
    public Request3Response executeRequest3() {
        long start = System.currentTimeMillis();

        String[][] request3 = this.repository.executeRequest3();

        List<Request30Response> responses = new ArrayList<>();

        for (String[] line : request3) {
            responses.add(RequestResponseMapper.mapPostgres3(line));
        }

        return Request3Response.builder().elapsedMsTime(System.currentTimeMillis() - start).payload(responses).build();
    }
}
