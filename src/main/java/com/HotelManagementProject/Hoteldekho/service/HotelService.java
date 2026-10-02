package com.HotelManagementProject.Hoteldekho.service;

import com.HotelManagementProject.Hoteldekho.dto.HotelDto;
import com.HotelManagementProject.Hoteldekho.entity.Hotel;
public interface HotelService {
    HotelDto CreateNewHotel(HotelDto hotelDto);
    HotelDto GetHotelById(Long id);
    HotelDto UpdateHotelById(Long id, HotelDto hotelDto);
    void DeleteHotelById(Long id);
    void ActivateHotel(Long hotelId);
}
