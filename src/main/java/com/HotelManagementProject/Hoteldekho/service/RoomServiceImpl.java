package com.HotelManagementProject.Hoteldekho.service;

import com.HotelManagementProject.Hoteldekho.dto.RoomDto;
import com.HotelManagementProject.Hoteldekho.entity.Hotel;
import com.HotelManagementProject.Hoteldekho.entity.Room;
import com.HotelManagementProject.Hoteldekho.exception.ResourceNotFoundException;
import com.HotelManagementProject.Hoteldekho.repository.HotelRepository;
import com.HotelManagementProject.Hoteldekho.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@Slf4j
@RequiredArgsConstructor

public class RoomServiceImpl implements RoomService {
    private final ModelMapper modelMapper;
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final InventoryService inventoryService;

    @Override
    public RoomDto CreateRooms(Long hotelId, RoomDto roomDto) {
       log.info("Creating A New Room {}",roomDto.getType());
       Room createRoom=modelMapper.map(roomDto,Room.class); // RoomDto-> change-> Actual Entity
        Hotel hotel=hotelRepository.
                    findById(hotelId).
                    orElseThrow(()->new ResourceNotFoundException("Hotel Does Not Exist"));
        // Now attach this hotel id to the room
        createRoom.setHotel(hotel);
        createRoom=roomRepository.save(createRoom);
        if(!hotel.getSetActive())
        {
            inventoryService.initializeRoomForYear(createRoom);
        }
        return modelMapper.map(createRoom,RoomDto.class);
    }

    @Override
    public RoomDto GetRoomById(Long roomId) {
        Room GetRoom=roomRepository.
                        findById(roomId).
                        orElseThrow(()-> new ResourceNotFoundException("Room With This ID Does Not exist "));
        return modelMapper.map(GetRoom,RoomDto.class);
    }

    @Override
    public List<RoomDto> GetAllRoomById(Long hotelId) {
        Hotel hotel=hotelRepository.
                findById(hotelId).
                orElseThrow(()->new ResourceNotFoundException("Hotel Does Not Exist"));
        return hotel.getRooms().
                stream().
                map((element)->
                modelMapper.map(element,RoomDto.class)).
                collect(Collectors.toList());
    }

    @Override
    public RoomDto UpdateRoomById(Long hotelId, Long roomId, RoomDto roomDto) {
        Hotel hotel=hotelRepository.
                findById(hotelId).
                orElseThrow(()->new ResourceNotFoundException("Hotel Does Not Exist"));
        Room GetRoomById=roomRepository.
                findById(roomId).
                orElseThrow(()-> new ResourceNotFoundException("Room With This ID Does Not exist "));
        modelMapper.map(roomDto,GetRoomById);
        GetRoomById=roomRepository.save(GetRoomById);
        
        return modelMapper.map(GetRoomById,RoomDto.class);

    }

    @Override
    public void DeleteRoomById(Long roomId) {
        boolean exist=roomRepository.existsById(roomId);
        if(!exist)
        {
            throw new ResourceNotFoundException("RoomId Not Exists");
        }
        roomRepository.deleteById(roomId);
        Room room=roomRepository.findById(roomId).orElseThrow(()-> new ResourceNotFoundException("Id " +
                "Not Exists "));
        inventoryService.deleteFutureInventory(room);
    }
}
