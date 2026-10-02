package com.HotelManagementProject.Hoteldekho.controller;

import com.HotelManagementProject.Hoteldekho.dto.HotelDto;
import com.HotelManagementProject.Hoteldekho.repository.HotelRepository;
import com.HotelManagementProject.Hoteldekho.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/hotelManager")
@RequiredArgsConstructor
@Slf4j
public class HotelAdminController {
    private final HotelService hotelService;
        @PostMapping("/createHotel")
        public ResponseEntity<HotelDto>CreateNewHotel(@RequestBody HotelDto hotelDto)
        {
            log.info("Attempting to Create A Hotel");
            HotelDto CreateHotel=hotelService.CreateNewHotel(hotelDto);
            return new ResponseEntity<>(CreateHotel, HttpStatus.CREATED);
        }
        @GetMapping("/hotelId/{id}")
        public ResponseEntity<HotelDto>GetHotelById(@PathVariable Long id)
        {
            log.info("Attempting to a get A Id ");
            HotelDto GetByHotelID=hotelService.GetHotelById(id);
            return new ResponseEntity<>(GetByHotelID,HttpStatus.OK);
        }
        @PutMapping("/updateHotelById/{id}")
        public ResponseEntity<HotelDto>UpdateHotelById( @PathVariable Long  id,@RequestBody HotelDto hotelDto)
        {
            HotelDto UpdateById=hotelService.UpdateHotelById(id,hotelDto);
            return new ResponseEntity<>(UpdateById,HttpStatus.OK);
        }
        @DeleteMapping("deleteHotelById/{id}")
        public ResponseEntity<Void>DeleteHotelById(@PathVariable Long id)
        {
            hotelService.DeleteHotelById(id);
            return ResponseEntity.noContent().build();
        }
        @PatchMapping("/{hotelId}")
        public ResponseEntity<Void>ActivateHotel(@PathVariable Long hotelId)
        {
            hotelService.ActivateHotel(hotelId);
            return ResponseEntity.noContent().build();
        }

}
