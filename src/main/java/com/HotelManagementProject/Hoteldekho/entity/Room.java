package com.HotelManagementProject.Hoteldekho.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="Rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "RoomType")
    private String type;
    private BigDecimal bestPrice;
    @CreationTimestamp
    @Column(name="createdAt")
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;
    @CollectionTable
    @ElementCollection
    @Column(name= "amenities")
    private List<String>amenities;
    @CollectionTable
    @ElementCollection
    @Column(name = "photos")
    private List<String>photos;
    private int totalCount;
    private int capacity;




    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;





}
