package com.softarch.carrental.rental.reader.business.service;

import com.softarch.carrental.rental.reader.business.query.GetRentalInfoQuery;
import com.softarch.carrental.rental.reader.business.query.GetRentalInfoQueryResponse;
import com.softarch.carrental.rental.reader.persistence.entity.Rental;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class RentalQueryService {

    private final QueryGateway queryGateway;

    public RentalQueryService(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    public CompletableFuture<GetRentalInfoQueryResponse> getRentalInfoById(UUID rentalRequestId) {
        log.info("========> calling query gateway for rental info by ud: " + rentalRequestId);
        return queryGateway.query(new GetRentalInfoQuery(rentalRequestId), Rental.class)
          .thenApply(GetRentalInfoQueryResponse::new);
    }
}
