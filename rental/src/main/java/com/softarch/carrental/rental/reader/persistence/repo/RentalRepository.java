package com.softarch.carrental.rental.reader.persistence.repo;

import com.softarch.carrental.rental.reader.persistence.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RentalRepository extends JpaRepository<Rental, UUID> {

}
