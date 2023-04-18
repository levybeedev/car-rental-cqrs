package com.softarch.carrental.rental.writer.service;

import com.softarch.carrental.rental.writer.command.ConfirmRentalCommand;
import com.softarch.carrental.rental.writer.command.CreateRentalCommand;
import com.softarch.carrental.rental.writer.command.PickCarCommand;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RentalCommandService {

    private CommandGateway commandGateway;

    public RentalCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public void createRentalRequest(CreateRentalCommand createRentalCommand) {
        log.info("========> calling command gateway for create rental: " + createRentalCommand.getCustomerName());
        commandGateway.send(createRentalCommand);
    }

    public void confirmRentalRequest(ConfirmRentalCommand confirmRentalCommand) {
        log.info("========> calling command gateway for confirm rental: " + confirmRentalCommand.getRentalRequestId());
        commandGateway.send(confirmRentalCommand);
    }

    public void pickCar(PickCarCommand pickCarCommand) {
        log.info("========> calling command gateway for pick car: " + pickCarCommand.getRentalRequestId());
        commandGateway.send(pickCarCommand);
    }

}
