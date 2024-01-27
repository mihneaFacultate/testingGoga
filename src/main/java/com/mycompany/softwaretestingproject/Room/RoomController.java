package com.mycompany.softwaretestingproject.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public String showRoomsList(Model model){
        List<Room> listRooms = roomService.listAll();
        model.addAttribute("listRooms", listRooms);
        return "rooms";
    }

    @GetMapping("/rooms/new")
    public String showNewRoomForm(Model model){
        model.addAttribute("room", new Room());
        model.addAttribute("pageTitle", "Add room");
        return "roomForm";
    }

    @PostMapping("/rooms/save")
    public String saveRoom(Room room, RedirectAttributes redirectAttributes){
        room.setFreeRoom(true);
        redirectAttributes.addFlashAttribute("message","The room has been saved!");
        roomService.save(room);
        return "redirect:/rooms";
    }

    @GetMapping("/rooms/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes){
        try {
            Room room = roomService.getRoom(id);
            model.addAttribute(room);
            model.addAttribute("room", room);
            model.addAttribute("pageTitle", "Edit Room (ID: " + id + ")");
            return "roomForm";
        }catch (RoomNotFoundException e){
            redirectAttributes.addFlashAttribute("message","Unable to get the room with that id");
            return "redirect:/rooms";
        }
    }

    @GetMapping("/rooms/delete/{id}")
    public String deleteRoom(@PathVariable("id") Integer id,  RedirectAttributes redirectAttributes){
        try {
            roomService.deleteRoom(id);
            redirectAttributes.addFlashAttribute("message","Room has been deleted!");
        }catch (RoomNotFoundException e){
            redirectAttributes.addFlashAttribute("message","Unable to delete the room with that id");
        }
        return "redirect:/rooms";
    }
}