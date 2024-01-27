package com.mycompany.softwaretestingproject.Room;

import com.mycompany.softwaretestingproject.Room.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepositoryInterface extends CrudRepository<Room, Integer>{
    public Long countById(Integer id);
}
