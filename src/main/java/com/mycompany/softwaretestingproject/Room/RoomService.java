package com.mycompany.softwaretestingproject.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepositoryInterface repo;

    public List<Room> listAll(){
        return (List<Room>) repo.findAll();
    }

    public void save(Room room) {
        repo.save(room);
    }

    public Room getRoom(Integer id) throws RoomNotFoundException{
        Optional<Room> result = repo.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new RoomNotFoundException("Couldn't find any user with the id: " + id);
    }

    public void deleteRoom(Integer id) throws RoomNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count ==0) {
            throw new RoomNotFoundException("Couldn't find any user with the id: " + id);
        }
        repo.deleteById(id);
    }
}
