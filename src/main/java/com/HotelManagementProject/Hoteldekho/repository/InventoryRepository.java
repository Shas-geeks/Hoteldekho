package com.HotelManagementProject.Hoteldekho.repository;

import com.HotelManagementProject.Hoteldekho.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
}
