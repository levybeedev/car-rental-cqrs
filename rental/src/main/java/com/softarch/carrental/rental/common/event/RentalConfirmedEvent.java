package com.softarch.carrental.rental.common.event;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class RentalConfirmedEvent {
    private UUID rentalRequestId;
    private String carId;
    private UUID contractId;
}
