package com.softarch.carrental.rental.reader.business.query;

import com.softarch.carrental.rental.common.model.CarCategory;
import com.softarch.carrental.rental.common.model.RentalStatus;
import com.softarch.carrental.rental.reader.persistence.entity.Rental;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class GetRentalInfoQueryResponse {
    private UUID requestId;
    private CarCategory category;
    private String customerName;

    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String locationFrom;
    private String locationTo;

    private RentalStatus status;

    private UUID contractId;
    private Integer price;
    private String carId;

    private LocalDateTime pickedTime;
    private String pickNotes;

    private LocalDateTime droppedTime;
    private String droppedNotes;

    private LocalDateTime verifiedTime;
    private String verifiedNotes;

    public GetRentalInfoQueryResponse(Rental rental) {
        requestId = rental.getRequestId();
        customerName = rental.getCustomerName();
        dateFrom = rental.getDateFrom();
        dateTo = rental.getDateTo();
        locationFrom = rental.getLocationFrom();
        locationTo = rental.getLocationTo();
        price = rental.getPrice();
        category = rental.getCategory();
        status = rental.getStatus();
        carId = rental.getCarId();
        contractId = rental.getContractId();
        pickedTime = rental.getPickedTime();
        pickNotes = rental.getPickNotes();
        droppedNotes = rental.getDroppedNotes();
        droppedTime = rental.getDroppedTime();
        verifiedNotes = rental.getVerifiedNotes();
        verifiedTime = rental.getVerifiedTime();
    }
}
