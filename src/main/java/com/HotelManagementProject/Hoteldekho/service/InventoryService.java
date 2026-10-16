package com.HotelManagementProject.Hoteldekho.service;
import com.HotelManagementProject.Hoteldekho.dto.HotelDto;
import com.HotelManagementProject.Hoteldekho.dto.HotelSearchRequest;
import com.HotelManagementProject.Hoteldekho.entity.Room;
import org.springframework.data.domain.Page;

public interface InventoryService {
    void initializeRoomForYear(Room room);
    void deleteAllInventories(Room room);
     Page<HotelDto> searchHotels(HotelSearchRequest hotelSearchRequest);

}
