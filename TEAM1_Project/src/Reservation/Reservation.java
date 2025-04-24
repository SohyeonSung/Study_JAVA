package Reservation;

import java.util.Date;

public class Reservation {
    private int reservationId;
    private int customerId;
    private int roomNumber;
    private Date checkInDate;
    private Date checkOutDate;

    // 생성자
    public Reservation(int reservationId, int customerId, int roomNumber, Date checkInDate, Date checkOutDate) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    // Getter, Setter
    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId +
               "\nCustomer ID: " + customerId +
               "\nRoom Number: " + roomNumber +
               "\nCheck-In Date: " + checkInDate +
               "\nCheck-Out Date: " + checkOutDate;
    }
}
