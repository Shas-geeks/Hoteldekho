package com.HotelManagementProject.Hoteldekho.dto;

import com.HotelManagementProject.Hoteldekho.entity.Hotel;
import com.HotelManagementProject.Hoteldekho.entity.Room;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class InventoryDto {
    private Long id;
    private Long hotel_id;
    private Long Room_id;
    private Integer bookedCount;
    private Integer totalCount;
    private LocalDate date;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private BigDecimal surgeFactor;
    private boolean closed;
}
