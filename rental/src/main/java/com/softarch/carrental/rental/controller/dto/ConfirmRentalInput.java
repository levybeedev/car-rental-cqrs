package com.softarch.carrental.rental.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConfirmRentalInput {
    private String rentalRequestId;
    private String carId;
}
