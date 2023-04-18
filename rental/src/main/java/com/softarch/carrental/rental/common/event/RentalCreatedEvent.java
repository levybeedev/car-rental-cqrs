package com.softarch.carrental.rental.common.event;

import com.softarch.carrental.rental.common.model.CarCategory;
import com.softarch.carrental.rental.common.model.RentalStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
public class RentalCreatedEvent {
    private UUID requestId;
    private String customerName;
    private CarCategory category;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String locationFrom;
    private String locationTo;
    private Integer price;
    private RentalStatus status;
}
