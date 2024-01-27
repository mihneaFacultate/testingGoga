package com.mycompany.softwaretestingproject;

import com.mycompany.softwaretestingproject.Room.Room;
import com.mycompany.softwaretestingproject.Room.RoomRepositoryInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class RoomRepositoryTest {

    @Autowired
    private RoomRepositoryInterface repo;

    @Test
    public void testAddNew(){
        Room room = new Room();
        room.setRoomName("Test Room Name 1");
        room.setRoomNumber("12");
        room.setFreeRoom(false);
        room.setDetails("Test details in ere");
        room.setPrice(12.1);
        Room savedRoom = repo.save(room);

        Assertions.assertNotNull(savedRoom.getId());
    }

    @Test
    public void testFindAll(){
        Iterable<Room> rooms = repo.findAll();
        for (Room room: rooms){
            Assertions.assertNotNull(room);
            System.out.println(room);
        }
    }

    @Test
    public void testUpdateRoom(){
        Integer roomId = 1;
        Optional<Room> optRoom = repo.findById(roomId);
        Room room = optRoom.get();
        room.setDetails("New room details");
        repo.save(room);

        Room updatedRoom = repo.findById(roomId).get();
        Assertions.assertEquals(updatedRoom.getDetails(), "New room details");
    }

    @Test
    public void testDeleteRoom(){
        Integer roomId = 3;
        repo.deleteById(roomId);
        Optional<Room> optRoom = repo.findById(roomId);
        assert(optRoom).isEmpty();
    }
}
