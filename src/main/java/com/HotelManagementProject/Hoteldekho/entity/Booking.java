package com.HotelManagementProject.Hoteldekho.entity;

import com.HotelManagementProject.Hoteldekho.entity.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="Booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HotelId")
    private Hotel hotel;
    private Integer  totalRoom;
    @Column(name= "checkIn" ,nullable = false)
    private LocalDate checkIn;
    @Column(name = "checkOut" ,nullable = false)
    private LocalDate checkOut;
    @CreationTimestamp
    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name="updatedAt",nullable = false)
    private LocalDateTime updatedAt;
    @Enumerated(EnumType.STRING)
    @Column(name = "BookingStatus",nullable = false)
    private BookingStatus bookingStatus;
    @OneToOne
    @JoinColumn(name = "PaymentId" ,updatable = false)
    private Payment payment;
    @ManyToOne
    @JoinColumn(name = "RoomId",updatable = true,nullable = false)
   private Room room;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "BookingGuest",
            joinColumns = @JoinColumn(name = "bookingId"),
            inverseJoinColumns = @JoinColumn(name = "guestId")
    )
    private Set<Guest> guests;



}
