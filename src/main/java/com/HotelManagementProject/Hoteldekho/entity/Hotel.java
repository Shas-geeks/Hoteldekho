package com.HotelManagementProject.Hoteldekho.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="hotel")
public class Hotel {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(name = "Name",nullable = false)
   private String name;
   private String city;
   @CollectionTable(name = "hotel_photos")
   @ElementCollection
   private List<String> photos;
    @CollectionTable(name = "hotel_amenities")
    @ElementCollection
    private List<String> amenities;
   @CreationTimestamp
   @Column(name = "createdAt")
    private LocalDateTime createdAt;
   @Column(name="updatedAt")
   @UpdateTimestamp
   private LocalDateTime updatedAt;
    private Boolean SetActive;
   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="ContactInfo",nullable = false)
    private ContactInfo contactInfo;
   @ManyToOne
    private User user;
    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;


}
