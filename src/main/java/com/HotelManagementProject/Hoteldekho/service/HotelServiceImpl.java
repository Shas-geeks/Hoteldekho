package com.HotelManagementProject.Hoteldekho.service;

import com.HotelManagementProject.Hoteldekho.dto.HotelDto;
import com.HotelManagementProject.Hoteldekho.entity.Hotel;
import com.HotelManagementProject.Hoteldekho.entity.Room;
import com.HotelManagementProject.Hoteldekho.exception.ResourceNotFoundException;
import com.HotelManagementProject.Hoteldekho.repository.HotelRepository;
import com.HotelManagementProject.Hoteldekho.repository.RoomRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.misc.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;
    private final RoomRepository roomRepository;
    private final InventoryService inventoryService;
    @Override
    public HotelDto CreateNewHotel( HotelDto hotelDto)
    {
        log.info("Creating A New Hotel {}",hotelDto.getName());
        Hotel hotel=modelMapper.map(hotelDto,Hotel.class);
        log.info("Created Hotel with {}",hotelDto.getName());
        hotel=hotelRepository.save(hotel);
        return modelMapper.map(hotel,HotelDto.class);
    }
    @Override
    public HotelDto GetHotelById(Long id)
    {
        log.info("Creating Hotel By ID {}",id);
        Hotel hotel=hotelRepository.
                    findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Id not found : "+id));
        return modelMapper.map(hotel,HotelDto.class);
    }
    @Override
    public HotelDto UpdateHotelById(Long id, HotelDto hotelDto)
    {
        log.info("Attempting To Update HotelByID {}",id);
        // It carries a old record in DB
        Hotel UpdateHotel=hotelRepository.
                findById(id).
                orElseThrow(()->new ResourceNotFoundException("Hotel Not Exists "));
        // Here From Postman or front End we send the Updated Data in Dto , Bcz Dto is Data Transfer Layer
        modelMapper.map(hotelDto,UpdateHotel); // source->Destination   and it Transfer the updated record to this Entity(Update Hotel)
        UpdateHotel.setId(id);
        UpdateHotel=hotelRepository.save(UpdateHotel);
        return  modelMapper.map(UpdateHotel,HotelDto.class);

    }
    @Override
    @Transactional
    public void DeleteHotelById(Long id)
    {
        boolean exists=hotelRepository.existsById(id);
        if(!exists){
        throw new ResourceNotFoundException("Hotel Not Exists ");
        }
        hotelRepository.deleteById(id);
        // Also delete the Future Inventorty
        Room room=roomRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(
                "Delete the Future Hotel Inventory"
        ));
        inventoryService.deleteFutureInventory(room);
    }
    public void ActivateHotel(Long hotelId)
    {
        log.info("Activate The Hotel With ID :"+ hotelId);
        Hotel hotel=hotelRepository.findById(hotelId)
                                    .orElseThrow(()-> new ResourceNotFoundException("Hotel " +
                                            "with This Id Not exist"));
        hotel.setSetActive(true);
        for(Room rooms:hotel.getRooms())
        {
            inventoryService.initializeRoomForYear(rooms);
        }
        hotelRepository.save(hotel);
    }
}
