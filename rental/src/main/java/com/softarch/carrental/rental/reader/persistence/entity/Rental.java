package com.softarch.carrental.rental.reader.persistence.entity;

import com.softarch.carrental.rental.common.model.CarCategory;
import com.softarch.carrental.rental.common.model.RentalStatus;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Rental {

    @Id
    @NotNull
    private UUID requestId;
    @NotNull
    private CarCategory category;
    @NotNull
    private String customerName;

    @NotNull
    private LocalDate dateFrom;
    @NotNull
    private LocalDate dateTo;
    @NotNull
    private String locationFrom;
    @NotNull
    private String locationTo;

    @NotNull
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

    public UUID getRequestId() {
        return requestId;
    }

    public void setRequestId(UUID requestId) {
        this.requestId = requestId;
    }

    public CarCategory getCategory() {
        return category;
    }

    public void setCategory(CarCategory category) {
        this.category = category;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public String getLocationFrom() {
        return locationFrom;
    }

    public void setLocationFrom(String locationFrom) {
        this.locationFrom = locationFrom;
    }

    public String getLocationTo() {
        return locationTo;
    }

    public void setLocationTo(String locationTo) {
        this.locationTo = locationTo;
    }

    public RentalStatus getStatus() {
        return status;
    }

    public void setStatus(RentalStatus status) {
        this.status = status;
    }

    public UUID getContractId() {
        return contractId;
    }

    public void setContractId(UUID contractId) {
        this.contractId = contractId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public LocalDateTime getPickedTime() {
        return pickedTime;
    }

    public void setPickedTime(LocalDateTime pickedTime) {
        this.pickedTime = pickedTime;
    }

    public String getPickNotes() {
        return pickNotes;
    }

    public void setPickNotes(String pickNotes) {
        this.pickNotes = pickNotes;
    }

    public LocalDateTime getDroppedTime() {
        return droppedTime;
    }

    public void setDroppedTime(LocalDateTime droppedTime) {
        this.droppedTime = droppedTime;
    }

    public String getDroppedNotes() {
        return droppedNotes;
    }

    public void setDroppedNotes(String droppedNotes) {
        this.droppedNotes = droppedNotes;
    }

    public LocalDateTime getVerifiedTime() {
        return verifiedTime;
    }

    public void setVerifiedTime(LocalDateTime verifiedTime) {
        this.verifiedTime = verifiedTime;
    }

    public String getVerifiedNotes() {
        return verifiedNotes;
    }

    public void setVerifiedNotes(String verifiedNotes) {
        this.verifiedNotes = verifiedNotes;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "  requestId='" + requestId + '\'' +
                ", category='" + category + '\'' +
                ", customerName='" + customerName + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", locationFrom='" + locationFrom + '\'' +
                ", locationTo='" + locationTo + '\'' +
                ", status=" + status +
                ", contractId='" + contractId + '\'' +
                ", price=" + price +
                ", carId='" + carId + '\'' +
                ", pickedTime=" + pickedTime +
                ", pickNotes='" + pickNotes + '\'' +
                ", droppedTime=" + droppedTime +
                ", droppedNotes='" + droppedNotes + '\'' +
                ", verifiedTime=" + verifiedTime +
                ", verifiedNotes='" + verifiedNotes + '\'' +
                '}';
    }
}
