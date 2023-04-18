package com.softarch.carrental.rental.reader.business.query;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class GetRentalInfoQuery {
    private UUID rentalRequestId;
}
