package com.softarch.carrental.rental.reader.business.eventhandler;

import com.softarch.carrental.rental.common.event.CarPickedEvent;
import com.softarch.carrental.rental.common.event.RentalConfirmedEvent;
import com.softarch.carrental.rental.common.event.RentalCreatedEvent;
import com.softarch.carrental.rental.common.model.RentalStatus;
import com.softarch.carrental.rental.reader.business.query.GetRentalInfoQuery;
import com.softarch.carrental.rental.reader.exception.RentalNotFoundException;
import com.softarch.carrental.rental.reader.persistence.entity.Rental;
import com.softarch.carrental.rental.reader.persistence.repo.RentalRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@ProcessingGroup("rentals")
@Slf4j
public class RentalEventHandler {

    private RentalRepository repo;

    public RentalEventHandler(RentalRepository repo) {
        this.repo = repo;
    }

    @EventHandler
    public void on(RentalCreatedEvent event) {
        log.info("========> Projector: on rental request create: " + event.getRequestId());
        Rental rental = new Rental();
        rental.setRequestId(event.getRequestId());
        rental.setCustomerName(event.getCustomerName());
        rental.setCategory(event.getCategory());
        rental.setDateFrom(event.getDateFrom());
        rental.setDateTo(event.getDateTo());
        rental.setLocationFrom(event.getLocationFrom());
        rental.setLocationTo(event.getLocationTo());
        rental.setPrice(event.getPrice());
        rental.setStatus(event.getStatus());
        repo.save(rental);
    }

    @EventHandler
    public void on(RentalConfirmedEvent event) {
        log.info("========> Projector: on rental confirm: " + event.getRentalRequestId());
        Optional<Rental> rentalOpt = repo.findById(event.getRentalRequestId());
        Rental rental = rentalOpt.orElseThrow(() -> new RentalNotFoundException());
        rental.setStatus(RentalStatus.CONFIRMED);
        rental.setContractId(event.getContractId());
        rental.setCarId(event.getCarId());
        repo.save(rental);
    }

    @EventHandler
    public void on(CarPickedEvent event) {
        log.info("========> Projector: on car picked: " + event.getRentalRequestId());
        Optional<Rental> rentalOpt = repo.findById(event.getRentalRequestId());
        Rental rental = rentalOpt.orElseThrow(() -> new RentalNotFoundException());
        rental.setStatus(RentalStatus.PICKEDUP);
        rental.setPickNotes(event.getPickNotes());
        rental.setPickedTime(event.getPickedTime());
        repo.save(rental);
    }

    @QueryHandler
    public Rental handle(GetRentalInfoQuery query) {
        log.info("========> Projector: on get rental info query handling: " + query.getRentalRequestId());
        return repo.findById(query.getRentalRequestId()).orElse(null);
    }
}
