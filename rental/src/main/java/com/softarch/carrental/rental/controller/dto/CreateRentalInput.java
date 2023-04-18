package com.softarch.carrental.rental.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CreateRentalInput {
    private String customerName;
    private String dateFrom;
    private String dateTo;
    private String locationFrom;
    private String locationTo;
    private Integer price;
    private String category;
}
