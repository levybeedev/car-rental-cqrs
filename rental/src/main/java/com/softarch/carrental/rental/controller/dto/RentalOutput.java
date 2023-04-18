package com.softarch.carrental.rental.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class RentalOutput {
    private String requestId;
    private String customerName;
    private String dateFrom;
    private String dateTo;
    private String locationFrom;
    private String locationTo;
    private Integer price;
    private String category;
    private String status;

    private String contractId;
    private String carId;

    private String pickedTime;
    private String pickNotes;

    private String droppedTime;
    private String droppedNotes;

    private String verifiedTime;
    private String verifiedNotes;
}
