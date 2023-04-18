package com.softarch.carrental.rental.controller.mapper;

import com.softarch.carrental.rental.common.model.CarCategory;
import com.softarch.carrental.rental.controller.dto.ConfirmRentalInput;
import com.softarch.carrental.rental.controller.dto.CreateRentalInput;
import com.softarch.carrental.rental.controller.dto.PickCarInput;
import com.softarch.carrental.rental.controller.dto.RentalOutput;
import com.softarch.carrental.rental.reader.business.query.GetRentalInfoQueryResponse;
import com.softarch.carrental.rental.writer.command.ConfirmRentalCommand;
import com.softarch.carrental.rental.writer.command.CreateRentalCommand;
import com.softarch.carrental.rental.writer.command.PickCarCommand;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class RentalMapper {

    public static RentalOutput mapToOutput(GetRentalInfoQueryResponse response) {
        return RentalOutput.builder()
                .requestId(response.getRequestId().toString())
                .customerName(response.getCustomerName())
                .dateFrom(response.getDateFrom().toString())
                .dateTo(response.getDateTo().toString())
                .locationFrom(response.getLocationFrom())
                .locationTo(response.getLocationTo())
                .price(response.getPrice())
                .category(response.getCategory().toString())
                .status(response.getStatus().toString())
                .carId(response.getCarId())
                .contractId(response.getContractId() != null ? response.getContractId().toString() : null)
                .pickedTime(response.getPickedTime() != null ? response.getPickedTime().toString() : null)
                .droppedTime(response.getDroppedTime() != null ? response.getDroppedTime().toString() : null)
                .verifiedTime(response.getVerifiedTime() != null ? response.getVerifiedTime().toString() : null)
                .pickNotes(response.getPickNotes())
                .droppedNotes(response.getDroppedNotes())
                .verifiedNotes(response.getVerifiedNotes())
                .build();
    }

    public static CreateRentalCommand mapToCreateCommand(CreateRentalInput createRentalInput) {
        return CreateRentalCommand.builder()
                .customerName(createRentalInput.getCustomerName())
                .price(createRentalInput.getPrice())
                .locationFrom(createRentalInput.getLocationFrom())
                .locationTo(createRentalInput.getLocationTo())
                .category(CarCategory.valueOf(createRentalInput.getCategory()))
                .dateFrom(LocalDate.parse(createRentalInput.getDateFrom()))
                .dateTo(LocalDate.parse(createRentalInput.getDateTo()))
                .build();
    }

    public static ConfirmRentalCommand mapToConfirmCommand(ConfirmRentalInput confirmRentalInput) {
        return ConfirmRentalCommand.builder()
                .rentalRequestId(UUID.fromString(confirmRentalInput.getRentalRequestId()))
                .carId(confirmRentalInput.getCarId())
                .build();
    }

    public static PickCarCommand mapToPickCarCommand(PickCarInput pickCarInput) {
        return PickCarCommand.builder()
                .rentalRequestId(UUID.fromString(pickCarInput.getRentalRequestId()))
                .pickNotes(pickCarInput.getPickNotes())
                .pickedTime(LocalDateTime.parse(pickCarInput.getPickTime()))
                .build();
    }
}
