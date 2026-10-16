package com.HotelManagementProject.Hoteldekho.controller;

import com.HotelManagementProject.Hoteldekho.dto.HotelDto;
import com.HotelManagementProject.Hoteldekho.dto.HotelInfoDto;
import com.HotelManagementProject.Hoteldekho.dto.HotelSearchRequest;
import com.HotelManagementProject.Hoteldekho.service.HotelService;
import com.HotelManagementProject.Hoteldekho.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hotel")
public class HotelBrowseController {
    private final InventoryService inventoryService;
    private final HotelService hotelService;
    @GetMapping("/search")
    public ResponseEntity<Page<HotelDto>> searchHotel(@RequestBody HotelSearchRequest hotelSearchRequest)
    {
       Page<HotelDto> page=inventoryService.searchHotels(hotelSearchRequest); // we are searching like front end se
        // phle wo dega date aur room aur city wagaira phir ye searchhotel me jayega aur har hotel li inventory chrck hoge
        // jis hotel ki inventory book nhi hoge uska pagination fgorm me result aa jaayega
        return ResponseEntity.ok(page);
    }
    @GetMapping("/{hotelId}")
    public ResponseEntity<HotelInfoDto>getHotelInfo(@PathVariable Long hotelId)
    {
        return ResponseEntity.ok(hotelService.getHotelInfo(hotelId));
    }
}
