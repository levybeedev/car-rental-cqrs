package com.softarch.carrental.rental.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PickCarInput {
    private String rentalRequestId;
    private String pickTime;
    private String pickNotes;
}
