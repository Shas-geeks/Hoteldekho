package com.HotelManagementProject.Hoteldekho.service;

import com.HotelManagementProject.Hoteldekho.dto.RoomDto;

import java.util.List;

public interface RoomService {
    // Create  Room Interface   => Lekin kis hotel ka
     RoomDto CreateRooms(Long hotelId ,  RoomDto roomDto);

   // Get Room by Id( For A single room )
    RoomDto GetRoomById(Long roomId);

    // Get All room from a particular Hotel
    // api/v1/hotelmanager/hotel/{id}/rooms
     List<RoomDto> GetAllRoomById(Long hotelId);


    RoomDto UpdateRoomById(Long hotelId,Long RoomId, RoomDto roomDto);

    // Delete room
    void DeleteRoomById(Long roomId);
}
