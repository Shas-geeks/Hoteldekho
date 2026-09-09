package com.HotelManagementProject.Hoteldekho.dto;
import com.HotelManagementProject.Hoteldekho.entity.ContactInfo;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class HotelDto {
    private Long id;
    private String name;
    private String city;
    private List<String> photos;
    private List<String> amenities;
    private Boolean status;
    private ContactInfo contactInfo;
}
