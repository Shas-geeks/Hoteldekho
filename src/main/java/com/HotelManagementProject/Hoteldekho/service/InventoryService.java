package com.HotelManagementProject.Hoteldekho.service;
import com.HotelManagementProject.Hoteldekho.entity.Room;
public interface InventoryService {
    void initializeRoomForYear(Room room);
    void deleteFutureInventory(Room room);

}
