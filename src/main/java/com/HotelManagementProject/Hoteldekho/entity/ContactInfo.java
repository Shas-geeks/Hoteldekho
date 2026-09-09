package com.HotelManagementProject.Hoteldekho.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="ContactInfo")
public class ContactInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String completeAddress;
    private String location;
    private String email;
    @Column(name = "phone_number", length = 15, nullable = false)
    private String phoneNumber;
}
