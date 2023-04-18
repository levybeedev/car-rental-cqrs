package com.softarch.carrental.rental.common.event;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class CarPickedEvent {
    private UUID rentalRequestId;
    private LocalDateTime pickedTime;
    private String pickNotes;
}
