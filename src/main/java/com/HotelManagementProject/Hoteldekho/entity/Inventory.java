package com.HotelManagementProject.Hoteldekho.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name = "Room_id")
    private Room room;
    private String city;    // Price
    @Column(precision = 10, scale = 2)
    private BigDecimal price;
    @Column(nullable = false)
    private Integer bookedCount;
    @Column(nullable=false)
    private Integer totalCount;
    @Column(nullable = false)
    private LocalDate date;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Column(precision = 8,scale = 2)
    private BigDecimal surgeFactor;
    private boolean closed;
}
