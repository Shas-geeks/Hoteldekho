package com.HotelManagementProject.Hoteldekho.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "BookingGuest")
public class BookingGuest {
    // This entity think of HotelManger
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bookingId")
    private Booking booking;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="guestId")
    private Guest guest;


}