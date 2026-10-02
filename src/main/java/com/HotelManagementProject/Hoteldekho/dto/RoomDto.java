package com.HotelManagementProject.Hoteldekho.dto;
import com.HotelManagementProject.Hoteldekho.entity.Hotel;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private List<String> photos;
    private int totalCount;
    private int capacity;
    private HotelDto hotelDto;
}