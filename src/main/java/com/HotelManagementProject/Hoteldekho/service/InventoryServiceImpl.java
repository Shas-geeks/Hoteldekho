package com.HotelManagementProject.Hoteldekho.service;

import com.HotelManagementProject.Hoteldekho.dto.HotelDto;
import com.HotelManagementProject.Hoteldekho.dto.HotelSearchRequest;
import com.HotelManagementProject.Hoteldekho.entity.Hotel;
import com.HotelManagementProject.Hoteldekho.entity.Inventory;
import com.HotelManagementProject.Hoteldekho.entity.Room;
import com.HotelManagementProject.Hoteldekho.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
@Slf4j
 public class InventoryServiceImpl implements  InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ModelMapper modelMapper;
    // this method can be used for activatinf hotel or creating new rooms
    public void initializeRoomForYear(Room room)
    {
        LocalDate today=LocalDate.now();
        LocalDate endDate=today.plusYears(1);
        for(;!today.isAfter(endDate);today=today.plusDays(1))
        {
            Inventory inventory=Inventory.builder()
                    .hotel(room.getHotel())
                    .room(room)
                    .bookedCount(0)
                    .city(room.getHotel().getCity())
                    .date(today)
                    .price(room.getBestPrice())
                    .surgeFactor(BigDecimal.ONE)
                    .totalCount(room.getTotalCount())
                    .closed(false)
                    .build();
            inventoryRepository.save(inventory);
        }

    }


    public void deleteAllInventories(Room room)
    {
        LocalDate today=LocalDate.now();
        // It will delete the Inventory After Today that with this room
        inventoryRepository.deleteByRoom(room);

    }
    public Page<HotelDto>searchHotels(HotelSearchRequest hotelSearchRequest)
    {
        Pageable pageable= PageRequest.of(hotelSearchRequest.getPage(),hotelSearchRequest.getSize());
        Long dateCount= ChronoUnit.DAYS.between(hotelSearchRequest.getStartDate(),
                hotelSearchRequest.getEndDate())+1;
     Page<Hotel> hotelPage=  inventoryRepository.findHotelsWithAvailableInventory(
                hotelSearchRequest.getCity(),hotelSearchRequest.getStartDate(),
                hotelSearchRequest.getEndDate(),hotelSearchRequest.getRoomsCount(),dateCount,
                pageable);

        return hotelPage.map((element)->modelMapper.map(element,HotelDto.class));
    }
}
