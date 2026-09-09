package com.HotelManagementProject.Hoteldekho.dto;
import com.HotelManagementProject.Hoteldekho.entity.Hotel;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class RoomDto {
    private Long id;
    private String type;
    private BigDecimal bestPrice;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<String> amenities;
    private List<String>photos;
    private int totalCount;
    private int capacity;
    private Long hotel_id;   // only column id which was mapped here
   // private HotelDto hotelDto;  =? Either Dto entity if we want to give full detail while loading

}
