package Customers;

import java.sql.Date;

public class ReservationDTO {
    private int reservationId;
    private int roomNumber;
    private Date checkInDate;
    private Date checkOutDate;

    public ReservationDTO(int reservationId, int roomNumber, Date checkInDate, Date checkOutDate) {
        this.reservationId = reservationId;
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
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
        return "예약번호: " + reservationId + ", 방 번호: " + roomNumber +
               ", 체크인: " + checkInDate + ", 체크아웃: " + checkOutDate;
    }
}
