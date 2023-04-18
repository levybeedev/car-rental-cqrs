package com.softarch.carrental.rental.writer.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class ConfirmRentalCommand {
    @TargetAggregateIdentifier
    private UUID rentalRequestId;
    private String carId;
}
