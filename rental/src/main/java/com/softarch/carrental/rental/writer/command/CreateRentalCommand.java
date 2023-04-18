package com.softarch.carrental.rental.writer.command;

import com.softarch.carrental.rental.common.model.CarCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class CreateRentalCommand {
    private String customerName;
    private CarCategory category;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String locationFrom;
    private String locationTo;
    private Integer price;
}
