package com.HotelManagementProject.Hoteldekho.repository;

import com.HotelManagementProject.Hoteldekho.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.HotelManagementProject.Hoteldekho.entity.Room;

import java.time.LocalDate;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    void deleteByDateAfterAndRoom(LocalDate date,Room room);
}
