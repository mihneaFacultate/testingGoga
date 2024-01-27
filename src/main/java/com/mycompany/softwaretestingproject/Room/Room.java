package com.mycompany.softwaretestingproject.Room;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(nullable = false, name = "roomNumber")
    private String roomNumber;
    @Column(nullable = false, name = "roomPrice")
    private Double price;
    @Column(nullable = false, name = "roomDetails")
    private String details;
    @Column(nullable = false, name = "roomName")
    private String roomName;
    @Column(nullable = false, name = "freeRoom")
    private Boolean freeRoom;

    public Integer getId() {
        return id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public Double getPrice() {
        return price;
    }

    public String getDetails() {
        return details;
    }

    public String getRoomName() {
        return roomName;
    }

    public Boolean getFreeRoom() {
        return freeRoom;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setFreeRoom(Boolean freeRoom) {
        this.freeRoom = freeRoom;
    }


    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", price=" + price +
                ", details='" + details + '\'' +
                ", roomName='" + roomName + '\'' +
                ", freeRoom=" + freeRoom +
                '}';
    }
}
