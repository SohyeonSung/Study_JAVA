package Room;

import oracle.jdbc.proxy._Proxy_;

public class Room {
    private int roomNumber;  // 방 번호
    private String roomType; // 방 타입 (싱글, 더블, 스위트 등)
    private String roomStatus; // 방 상태 (빈방 -> O , 예약 중 -> X등)
    private int price;
    
    // 생성자
    public Room(int roomNumber, String roomType, String roomStatus) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomStatus = roomStatus;
        this.price = price;
    }

    // getter 및 setter
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
   
    
    @Override
    public String toString() {
        return "Room Number: " + roomNumber 
        		+ ", Type: " + roomType 
        		+ ", Status: " + roomStatus
        		+ ", Price: " + price;
    }
}












