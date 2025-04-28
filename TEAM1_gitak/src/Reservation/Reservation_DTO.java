package Reservation;

import java.sql.Date;

public class Reservation_DTO {
    private int reservationId; // 예약 번호
    private int customerId;  // 고객 ID (새로 추가)
    private int roomNumber; // 방 번호
    private Date checkInDate; // 체크인 날짜
    private Date checkOutDate; // 체크아웃 날짜
    

    public Reservation_DTO(int reservationId, int customerId, int roomNumber, Date checkInDate, Date checkOutDate) {
        this.reservationId = reservationId;
        this.customerId = customerId;
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
    
//    public String getReservationStatus() {
//        return reservationStatus;
//    }
//
//    public void setReservationStatus(String reservationStatus) {
//        this.reservationStatus = reservationStatus;
//    }

//    public Date getLastModified() {
//        return lastModified;
//    }
//
//    public void setLastModified(Date lastModified) {
//        this.lastModified = lastModified;
//    }

    @Override
    public String toString() {
        return "예약번호: " + reservationId + ", 고객 ID: " + customerId + 
        	", 방 번호: " + roomNumber +
               ", 체크인: " + checkInDate + ", 체크아웃: " + checkOutDate;
    }
}
