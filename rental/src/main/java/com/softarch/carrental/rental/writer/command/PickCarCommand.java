package com.softarch.carrental.rental.writer.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class PickCarCommand {
    @TargetAggregateIdentifier
    private UUID rentalRequestId;
    private LocalDateTime pickedTime;
    private String pickNotes;
}
