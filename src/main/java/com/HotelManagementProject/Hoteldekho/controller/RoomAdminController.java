package com.HotelManagementProject.Hoteldekho.controller;

import com.HotelManagementProject.Hoteldekho.dto.HotelDto;
import com.HotelManagementProject.Hoteldekho.dto.RoomDto;
import com.HotelManagementProject.Hoteldekho.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/hotelManager")
@RequiredArgsConstructor
@Slf4j
public class RoomAdminController {
    private final RoomService roomService;
// Create Mapping [/admin/hotelManager/CreateRooms]
    @PostMapping("/hotel/{hotelId}/CreateRooms")
    public ResponseEntity<RoomDto> CreateRoom( @PathVariable Long hotelId,@RequestBody RoomDto roomDto)
    {
        log.info("Attempting to Create A Room");
        RoomDto CreateRoom=roomService.CreateRooms(hotelId,roomDto);
        return new ResponseEntity<>(CreateRoom, HttpStatus.CREATED);
    }
    @GetMapping("/GetRoomById/{roomId}")
    public ResponseEntity<RoomDto> GetRoomById(@PathVariable Long roomId)
    {
        RoomDto GetById=roomService.GetRoomById(roomId);
        return new ResponseEntity<>(GetById,HttpStatus.OK);
    }
    @GetMapping("/hotel/{hotelId}/rooms")
    public ResponseEntity<List<RoomDto>> GetAllRooms(@PathVariable Long hotelId)
    {
        log.info("Getting All the Hotel Rooms");
        List<RoomDto> listOfAllRooms=roomService.GetAllRoomById(hotelId);
        return new ResponseEntity<>(listOfAllRooms,HttpStatus.OK);
    }
    @PutMapping("/hotel/{hotelId}/rooms/{roomId}")
    public ResponseEntity<RoomDto> UpdateRoomById(@PathVariable Long hotelId, @PathVariable Long roomId, @RequestBody RoomDto roomDto)
    {
        log.info("Updating the Hotel Room");
        RoomDto UpdateRoomByID= roomService.UpdateRoomById(hotelId,roomId,roomDto);
        return ResponseEntity.ok(UpdateRoomByID);
    }
    @DeleteMapping("/deleteRoomBtId/{roomId}")
    public  ResponseEntity<Void>  DeleteRoomById(@PathVariable Long roomId)
    {
        roomService.DeleteRoomById(roomId);
        return ResponseEntity.noContent().build();
    }
}
