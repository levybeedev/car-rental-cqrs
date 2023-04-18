package com.softarch.carrental.rental.writer;

import com.softarch.carrental.rental.common.event.CarPickedEvent;
import com.softarch.carrental.rental.common.event.RentalConfirmedEvent;
import com.softarch.carrental.rental.common.event.RentalCreatedEvent;
import com.softarch.carrental.rental.common.model.RentalStatus;
import com.softarch.carrental.rental.writer.command.ConfirmRentalCommand;
import com.softarch.carrental.rental.writer.command.CreateRentalCommand;
import com.softarch.carrental.rental.writer.command.PickCarCommand;
import com.softarch.carrental.rental.writer.exception.InvalidRentalStatusException;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Aggregate
@Slf4j
public class RentalAggregate {

    @AggregateIdentifier
    private UUID rentalRequestId;
    private RentalStatus status;

    public RentalAggregate() {
    }

    @CommandHandler
    public RentalAggregate(CreateRentalCommand command) {
        log.info("========> aggreagate: received create rental command " + command.getCustomerName());
        AggregateLifecycle.apply(new RentalCreatedEvent(UUID.randomUUID(),
                command.getCustomerName(),
                command.getCategory(),
                command.getDateFrom(),
                command.getDateTo(),
                command.getLocationFrom(),
                command.getLocationTo(),
                command.getPrice(),
                RentalStatus.REQUESTED));
    }

    @CommandHandler
    public void handle(ConfirmRentalCommand command) {
        log.info("========> aggreagate: received confirm rental command " + command.getRentalRequestId());
        if (status != RentalStatus.REQUESTED) {
            throw new InvalidRentalStatusException();
        }
        AggregateLifecycle.apply(new RentalConfirmedEvent(rentalRequestId,
                command.getCarId(),
                UUID.randomUUID()));
    }

    @CommandHandler
    public void handle(PickCarCommand command) {
        log.info("========> aggreagate: received picked car command " + command.getRentalRequestId());
        if (status != RentalStatus.CONFIRMED) {
            throw new InvalidRentalStatusException();
        }
        AggregateLifecycle.apply(new CarPickedEvent(rentalRequestId,
                command.getPickedTime(),
                command.getPickNotes()));
    }

    @EventSourcingHandler
    public void on(RentalCreatedEvent event) {
        log.info("========> aggreagate: handling rental create event " + event.getCustomerName());
        rentalRequestId = event.getRequestId();
        status = event.getStatus();
    }

    @EventSourcingHandler
    public void on(RentalConfirmedEvent event) {
        log.info("========> aggreagate: handling rental confirm event " + event.getRentalRequestId());
        status = RentalStatus.CONFIRMED;
    }

    @EventSourcingHandler
    public void on(CarPickedEvent event) {
        log.info("========> aggreagate: handling car pick event " + event.getRentalRequestId());
        status = RentalStatus.PICKEDUP;
    }

}
