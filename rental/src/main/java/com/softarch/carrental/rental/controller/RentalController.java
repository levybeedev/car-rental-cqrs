package com.softarch.carrental.rental.controller;

import com.softarch.carrental.rental.controller.dto.ConfirmRentalInput;
import com.softarch.carrental.rental.controller.dto.CreateRentalInput;
import com.softarch.carrental.rental.controller.dto.PickCarInput;
import com.softarch.carrental.rental.controller.dto.RentalOutput;
import com.softarch.carrental.rental.controller.mapper.RentalMapper;
import com.softarch.carrental.rental.reader.business.service.RentalQueryService;
import com.softarch.carrental.rental.writer.service.RentalCommandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Controller
@Slf4j
public class RentalController {

    private RentalQueryService queryService;
    private RentalCommandService commandService;

    public RentalController(RentalQueryService queryService, RentalCommandService commandService) {
        this.queryService = queryService;
        this.commandService = commandService;
    }

    @QueryMapping
    public CompletableFuture<RentalOutput> rentalById(@Argument String id) {
        log.info("========> Controller: rental by id: " + id);
        return queryService.getRentalInfoById(UUID.fromString(id)).thenApply(RentalMapper::mapToOutput);
    }

    @MutationMapping
    public String requestRental(@Argument CreateRentalInput createRentalInput) {
        log.info("========> Controller: request rental: " + createRentalInput.getCustomerName());
        commandService.createRentalRequest(RentalMapper.mapToCreateCommand(createRentalInput));
        return null;
    }

    @MutationMapping
    public String confirmRental(@Argument ConfirmRentalInput confirmRentalInput) {
        log.info("========> Controller: confirm rental id: " + confirmRentalInput.getRentalRequestId());
        commandService.confirmRentalRequest(RentalMapper.mapToConfirmCommand(confirmRentalInput));
        return confirmRentalInput.getRentalRequestId();
    }

    @MutationMapping
    public String pickCar(@Argument PickCarInput pickCarInput) {
        log.info("========> Controller: pick car: " + pickCarInput.getRentalRequestId());
        commandService.pickCar(RentalMapper.mapToPickCarCommand(pickCarInput));
        return pickCarInput.getRentalRequestId();
    }



}
